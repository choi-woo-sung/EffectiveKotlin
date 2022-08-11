package chapter8

import java.util.*

fun main() {
    `성능적으론 차이나지 않지만 가독성 향상됨`()

}

fun ProductsSequenceProcessing() : String{
    val clientList = mutableListOf<News>()
    return clientList.asSequence()
        .filter {it.adult}
        .flatMap {it.products.asSequence() }
        .filter {it.bought}
        .mapNotNull {it.price}
        .joinToString(separator = "+") {"$$it"}
}

fun productsListProcessing(): String {
    val clientList = mutableListOf<News>()
    return clientList.filter { it.adult }
        .flatMap {it.products}
        .filter{it.bought}
        .map {it.price}
        .filterNotNotNull()
        .map {"$$it"}
        .joinToString(separator = "+")
}

private fun `성능적으론 차이나지 않지만 가독성 향상됨`() {
    //before
    val news = listOf<News>(News(true, "", 30))
    val visibleNews = mutableListOf<News>()
    for (n in news) {
        if (n.visible) {
            visibleNews.add(n)
        }
    }

    Collections.sort(visibleNews, { n1, n2 ->
        n2.publishedAt - n1.publishedAt
    })
    val newsItemAdpater = mutableListOf<NewsItemAdapter>()
    for (n in visibleNews) {
        newsItemAdpater.add(NewsItemAdapter(n))
    }
    //After
    val newsItemAdapters = news.filter { it.visible }.sortedBy { it.publishedAt }.map(::NewsItemAdapter)
}

data class NewsItemAdapter(
    val news: News
)


data class News(
    val visible: Boolean,
    val title: String,
    val publishedAt: Int
)
