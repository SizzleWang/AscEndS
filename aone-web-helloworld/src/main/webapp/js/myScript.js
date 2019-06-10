// 在demo段落展示日期
function displayDate(){
    /*
    document 对象使我们可以从脚本中对 HTML 页面中的所有元素进行访问。
    getElementById返回对拥有指定 id 的第一个对象的引用。
    */
    document.getElementById("demo").innerHTML=Date();
}