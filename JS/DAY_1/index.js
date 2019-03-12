var da = new Date();
var a = 10;
            
setTimeout(function() {
    document.getElementById('a').innerHTML = da.toLocaleDateString();
    //$('#a').text=da.toLocaleDateString();
}, 1000);

(function imediateInvoke(a){
    a= 100;
    console.log(a);
})();


var ta = document.getElementById('table');
ta.border=1;
console.log(ta);

for(i =1; i<11; i++){
    var tr= document.createElement("TR");
    console.log(tr);

    ta.appendChild(tr);

    for(var j=1; j<11; j++){
        var td = document.createElement("TD");
        td.setAttribute("id",((i-1)*10)+j);
        var t = document.createTextNode(j);
        td.appendChild(t);

        tr.appendChild(td);
        
    }
}



