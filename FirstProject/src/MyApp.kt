fun main(args: Array<String>) {

var b1=book("sherlokhomes","someone",234,400)
    b1.display()

    var b2=book("hermal","setandio")
    b2.display()
}


class book(var title: String, var author: String,var price: Int,var pages: Int)
{

    var title2:String=title;
    fun display()
    {
        println("$title2 $author $price $pages")
    }
constructor(title: String, author: String) : this(title, author, 35,12)
}


