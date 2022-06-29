import io.github.fastily.jwiki.core.Wiki
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.JavaNetCookieJar
import java.net.CookieManager
import java.net.CookiePolicy
import java.net.HttpCookie
import java.net.URI

fun main() {
    val wiki = Wiki.Builder()
        .withApiEndpoint("http://localhost:8081/api.php".toHttpUrlOrNull())
        .withLogin("mediawiki", "passwordIssue42")
        .build()

    for (i in 1..500) {
        val status = wiki.edit("Page $i", "New Page $i - ${Math.random()}" , "issue/42")
        println("edit page 'Page $i' - $status")
    }

}
