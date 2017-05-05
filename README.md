# recruitment

Using your favorite language / framework / libraries build a service, that will accept a request with text parameter on input.

It will return maximum of 5 books and maximum of 5 albums that are related to the input term. The response elements will only contain title, authors(/artists) and information whether it's a book or an album.

For albums please use the Spotify API: https://developer.spotify.com/web-api/search-item/
eg. https://api.spotify.com/v1/search?q=America&type=album&limit=5

For books please use Google Books API: https://developers.google.com/books/docs/v1/reference/volumes/list
eg. https://www.googleapis.com/books/v1/volumes?q=America&maxResults=5
Sort the result by title alphabetically.

Make sure the software is production-ready from resilience, stability and performance point of view. 

The stability of the downstream service may not be affected by the stability of the upstream services. 

Results originating from one upstream service may not affect the results originating from the other upstream service.

Make sure the service:
* is self-documenting
* exposes metrics on response times for upstream services
* exposes health check

Limit of results on upstream services must be configurable per environment and preconfigured to 5.

Please document how I can run it.

You have time until the end of Sunday, May 14 (but the earlier you submit it, the earlier we can check it and reply to you).
