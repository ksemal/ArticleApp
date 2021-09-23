# Article app
## Details and Description
### Functionality
Article app allows you:
* to load and see list of articles from News API
* see details of each article in a web view
* add an article to saved tab to read it later

### App is using
* MVVM Clean Architecture:

      1. Presentation Layer:
            - View is represented by 1 activity and 3 fragments: Main Activity, News Fragment, Info Fragment, Saved Fragment.
            - ViewModel to get data based on use cases from data source (remote or local)
            - RecycleView adapter is being used in News Fragment as well as in Saved Fragment
      2. Domain Layer:
            - Use cases:
                  - News Fragment: get news, get searched news
                  - Info Fragment: save news
                  - Saved Fragment: get saved news, delete saved news
            - Repository helps communicate between view model and data source and holds logic of each use case
      3. Data Layer:
            - Remote Data Source represented by NewsAPIService interface to make API query to get news and searched news from API 
            - Local Data Source is represented by ArticleDatabase class and Article DAO object to save, get and delete entries from local database. Entities data classes are created to hold information about api response, article and source.

* Retrofit - HTTP client to prepare API call query from News API
* Room persistence library to work with database
* JSON To Kotlin Class ​(JsonToKotlinClass)​ - Plugin for Kotlin to convert Json String into Kotlin data class code quickly. Used to generate entities data classes
* Coroutines to make API calls and getting database data in the background threads or UI thread on different coroutines
* Dagger Hilt - framework for dependency injection
* View Binding to improve app performance and help prevent memory leaks and null pointer exceptions
* RecyclerView with DiffUtil and custom item swipe gesture to display list of articles
* Navigation component to navigate between fragments and pass the data with args
* Glide is an image loading framework to add images in UI from the url

### Challenges

* Continued to explore Dependency Injection with Dagger Hilt

### Screenshots

Scroll through the list of articles with paging
https://user-images.githubusercontent.com/42688915/134586984-af1baf89-b0ba-4711-8235-8c770825cd52.mov


Search for a specific article from the list
https://user-images.githubusercontent.com/42688915/134587002-27e83eb8-aba0-4872-aa2e-7869f6bdc411.mov


Add article to saved tab
https://user-images.githubusercontent.com/42688915/134587050-4f9bacdd-9fc4-4968-8315-eb9bb0a3479a.mov


Delete article from sasved tab
https://user-images.githubusercontent.com/42688915/134587072-ae278955-f6d1-4585-8445-c316ad7471e2.mov


