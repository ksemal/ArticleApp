package com.example.articleapp.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sendRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val request = server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path)
                .isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=aaa33ccb400147b1adfd8cec82874b72")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctpageSize() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val articleList = responseBody?.articles
            Truth.assertThat(articleList?.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctpageContent() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val articleList = responseBody?.articles
            val article = articleList?.get(1)
            Truth.assertThat(article?.author).isEqualTo("Sami Fathi")
            Truth.assertThat(article?.url).isEqualTo("https://www.macrumors.com/2021/09/16/apple-watch-series-7-rumors-wrong/")
            Truth.assertThat(article?.publishedAt).isEqualTo("2021-09-16T13:57:43Z")
        }
    }
}