import io.github.fastily.jwiki.core.Wiki
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

fun main() {
    val wiki = Wiki.Builder()
        .withApiEndpoint("http://localhost:8080/api.php".toHttpUrlOrNull())
        .withLogin("mediawiki", "passwordIssue42")
        .withDebug(true)
        .build()

    for (i in 1..500) {
        wiki.edit("Page $i", "New Page $i - ${Math.random()}" , "issue/42")
    }

}
