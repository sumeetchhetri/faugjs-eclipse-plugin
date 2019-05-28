
function templatize(html, options, retFunc, isVarFromOptions, escH) {
    escH = escH === false ? false : true;
    if (!html) {
        if (retFunc) {
            return Function.apply(null, ["arg", "return '';"]);
        } else {
            return Function.apply(null, ["arg", "return '';"]).apply(null, [options]);
        }
    }

    isVarFromOptions = (!isVarFromOptions) ? false : true;
    var re = /<%(.*?)%>/g, reExp = /^#(.*)/g, reExpr = /^#(.*)/g, code = '', cursor = 0, match;
    var mulre = /##([\s\S]*?)##/g;
    var incre = /!!([a-zA-Z0-9_\-\.\s\/()]+)!!/g;
    var varnamere = /^[^a-zA-Z_$]|[^\\w$]/;

    var debugLines = {}

    var nhtml = '';
    while (match = mulre.exec(html)) {
        nhtml += html.slice(cursor, match.index);
        var htmlines = match[1].split("\n");
        for (var i = 0; i < htmlines.length; i++) {
            if (htmlines[i].trim() != "") {
                nhtml += "#" + htmlines[i] + "\n";
            } else {
                nhtml += "<!-- debug -->\n";
            }
        }
        cursor = match.index + match[0].length;
    }
    nhtml += html.substr(cursor, html.length - cursor);
    cursor = 0;
    html = nhtml;

    var add = function(line, js) {
        if (line != "") {
            var isvar = line.trim().match(reExpr);
            var tl = line;
            if (!isvar) {
                var escnot = false;
                if (line.trim()[0] == '!') {
                    tl = line.substring(line.indexOf("!") + 1);
                    escnot = true;
                }
                var dotnt = tl.split(".");
                var dospl = true;
                if(js && tl.indexOf("(")!=-1 && tl.indexOf(")")!=-1) {
                    var y = tl.replace(/"(.*)"/g, "");
                    if(y.indexOf("(")!=-1 && y.indexOf(")")!=-1) {
                        dospl = false;
                    }
                }
                var isjsvarflag = true;
                var jsvartl = "";
                for (var k = 0; k < dotnt.length; k++) {
                    if(!dospl) {
                        jsvartl = tl;
                        isjsvarflag = true;
                        escnot = true;
                        break;
                    } else if (k == 0 && js && isVarFromOptions && varnamere.test(dotnt[k])/* && options.hasOwnProperty(dotnt[k])*/) {
                        isjsvarflag &= true;
                        jsvartl = 'arg["' + dotnt[0] + '"]';
                    } else if (js && isVarFromOptions && varnamere.test(dotnt[k])) {
                        isjsvarflag &= true;
                        jsvartl += "." + dotnt[k];
                    } else {
                        isjsvarflag &= false;
                    }
                }

                if (isjsvarflag && escnot) {
                    line = line.substring(line.indexOf("!") + 1);
                }

                if (incre.test(line)) {
                    code += line + '\n';
                } else if (isjsvarflag) {
                    line = jsvartl;
                    if (escH) {
                        if (escnot) {
                            code += isvar ? (line + '\n') : ('____r_____.push(' + line + ');');
                        } else {
                            code += isvar ? (line + '\n') : ('____r_____.push(Fg.eh(' + line + '));');
                        }
                    } else {
                        code += isvar ? (line + '\n') : ('____r_____.push(' + line + ');');
                    }
                } else {
                    line = js ? tl : ('"' + tl.replace(/"/g, '\\"') + '"');
                    code += isvar ? (line + '\n') : ('____r_____.push(' + line + ');');
                }
            } else if (incre.test(line)) {
                code += line + '\n';
            } else {
                code += isvar ? (line + '\n') : ('____r_____.push(' + line + ');');
            }
            incre.lastIndex = 0;
        }
        return add;
    };
    var htmlines = html.split("\n");
    for (var i = 0; i < htmlines.length; i++) {
        cursor = 0;
        var htm = htmlines[i];
        var f = false;
        if(htm.trim()=="") {
            code += "//debug\n";
            continue;
        }
        while (match = re.exec(htm)) {
            f = true;
            add(htm.slice(cursor, match.index))(match[1], true);
            cursor = match.index + match[0].length;
        }
        if(f) {
            add(htm.substr(cursor, htm.length - cursor));
            code += "\n";
        } else {
            add(htm.substr(cursor, htm.length - cursor));
            if(code[code.length-1]!='\n')
                code += "\n";
        }
    }

    var addf = function(line, js) {
        if (line != '') {
            if (js || incre.test(line)) {
                code += line + '\n';
            } else {
                if (line.indexOf('____r_____.push(') == 0) {
                    code += line + "\n";
                } else {
                    code += '____r_____.push("' + line.replace(/"/g, '\\"') + '");\n';
                }
            }
            incre.lastIndex = 0;
        }
        return addf;
    };
    var ncode = code, code = '';
    htmlines = ncode.split("\n");
    for (var i = 0; i < htmlines.length; i++) {
        cursor = 0;
        var htm = htmlines[i].trim();
        var f = false;
        while (match = reExp.exec(htm)) {
            f = true;
            addf(htm.slice(cursor, match.index), false)(match[1], true);
            cursor = match.index + match[0].length;
        }
        if(f) addf(htm.substr(cursor, htm.length - cursor), false);
        else {
            code += htm + "\n";
        }
    }
    var fcode = 'function _te_____(arg){var ____r_____=[];';
    if (!isVarFromOptions) {
        for ( var k in options) {
            if (options.hasOwnProperty(k)) {
                fcode += 'var ' + k + '=' + 'arg["' + k + '"];';
            }
        }
    }

    var addI = function(line, ismatch) {
        if (line != "") {
            if (ismatch) {
                line = line.trim();
                var cmps = line.split(" ");
                code += "var _exttargs = {};\n";
                line = cmps[0];
                for (var i = 1; i < cmps.length; i++) {
                    var t = cmps[i].trim();
                    if (t.indexOf("(") == 0 && t.indexOf(")") == t.length - 1) {
                        t = t.substr(1, t.length - 2);
                    }
                    t = t.trim();
                    if (t != "") {
                        code += 'if(typeof(' + t + ') !== "undefined")_exttargs["' + t + '"] = ' + t + ';\n';
                    }
                }
                code += ('____r_____.push(Faug.includeTemplate(\"' + line.trim() + '\", _exttargs));\n');
            } else {
                code += line + '\n';
            }
        }
        return addI;
    };
    var ncode = code, code = '';
    htmlines = ncode.split("\n");
    for (var i = 0; i < htmlines.length; i++) {
        cursor = 0;
        var htm = htmlines[i];
        var f = false;
        while (match = incre.exec(htm)) {
            f = true;
            addI(htm.slice(cursor, match.index))(match[1], true);
            cursor = match.index + match[0].length;
        }
        if(f) addI(htm.substr(cursor, htm.length - cursor));
        else {
            code += htm + "\n";
        }
    }

    return fcode + "\n" + code + 'return ____r_____.join("");}';
    //code = code.replace(/[\r\t\n]/g, '');
    /*if (retFunc) {
        return Function.apply(null, ["arg", code]);
    } else {
        return Function.apply(null, ["arg", code]).apply(null, [options]);
    }
    return code;*/
}
