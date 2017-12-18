curl -XPUT {cups_elastic_search}/us_large_cities -d '
{
    "mappings": {
        "city": {
            "properties": {
                "city": {"type": "string"},
                "state": {"type": "string"},
                "location": {"type": "geo_point"}
            }
        }
    }
}
'