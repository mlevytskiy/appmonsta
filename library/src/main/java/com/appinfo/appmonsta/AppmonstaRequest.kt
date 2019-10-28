package com.appinfo.appmonsta

class AppmonstaRequest {

    private var packageName: String = ""

    fun packageName(value: String): AppmonstaRequest {
        packageName = value
        return this
    }

    private fun url(value: String): AppmonstaRequest {
        return this
    }

    private fun basicAuth(userName: String, password: String): AppmonstaRequest {
        return this
    }

    fun getUrl(): String {
        return "https://play.google.com/store/apps/details?id=" + packageName
    }

    fun produce(): String {
        return "{\n" +
                "    \"content_rating\": \"Everyone\",\n" +
                "    \"app_name\": \"Uklon - More Than a Taxi\",\n" +
                "    \"top_developer\": false,\n" +
                "    \"publisher_id_num\": \"7002416443562761532\",\n" +
                "    \"requires_os\": \"Varies with device\",\n" +
                "    \"related\": {\n" +
                "        \"related_apps\": [\n" +
                "            \"com.busfor.Busfor\",\n" +
                "            \"ee.mtakso.client\",\n" +
                "            \"ua.otaxi.client\",\n" +
                "            \"com.tx.driver\",\n" +
                "            \"com.shark.taxi.client\",\n" +
                "            \"com.bytelogics.bolt\",\n" +
                "            \"com.gettaxi.android\",\n" +
                "            \"com.taxsee.taxsee\",\n" +
                "            \"viavan.rider\",\n" +
                "            \"est.taxi.android\",\n" +
                "            \"com.ecabsmobileapplication\",\n" +
                "            \"com.ridehive.app\",\n" +
                "            \"com.adleritech.app.liftago.passenger\",\n" +
                "            \"com.sits.TaxiMoldova\",\n" +
                "            \"taxi.android.client\",\n" +
                "            \"com.primeleasing.citybee\",\n" +
                "            \"lt.etaksi.android\",\n" +
                "            \"com.taxime.client\",\n" +
                "            \"su.skat.client\",\n" +
                "            \"com.uznewmax.mytaxi\",\n" +
                "            \"com.geckolab.eotaxi.passenger\",\n" +
                "            \"com.shark.taxi.driver\",\n" +
                "            \"ee.mtakso.driver\",\n" +
                "            \"ru.yandex.taxi\",\n" +
                "            \"fr.chauffeurprive\",\n" +
                "            \"uptaxi.tulpar\",\n" +
                "            \"sk.hopin.taxiapp\",\n" +
                "            \"org.mapapps.mapyourtown.lviv\",\n" +
                "            \"kangaroo.lk.clientapp\",\n" +
                "            \"lt.cargo\"\n" +
                "        ],\n" +
                "        \"more_from_developer\": [\n" +
                "            \"ua.com.uklon.uklondriver\"\n" +
                "        ]\n" +
                "    },\n" +
                "    \"video_urls\": [\n" +
                "        \"https://www.youtube.com/embed/EldGMwn047g?ps=play&vq=large&rel=0&autohide=1&showinfo=0\"\n" +
                "    ],\n" +
                "    \"file_size\": \"Varies with device\",\n" +
                "    \"publisher_name\": \"Uklon\",\n" +
                "    \"id\": \"ua.com.uklontaxi\",\n" +
                "    \"price_currency\": \"USD\",\n" +
                "    \"genres\": [\n" +
                "        \"Travel & Local\"\n" +
                "    ],\n" +
                "    \"app_type\": \"APPLICATION\",\n" +
                "    \"icon_url\": \"https://lh3.googleusercontent.com/OA_SkFlirmBZpbEpDeZrkgdm9ns1iWqMwtby_naNanIirBM8z3z--UaT3saNetRXkTY\",\n" +
                "    \"content_rating_info\": \"\",\n" +
                "    \"interactive_elements\": \"\",\n" +
                "    \"version\": \"Varies with device\",\n" +
                "    \"publisher_url\": \"https://uklon.com.ua\",\n" +
                "    \"whats_new\": \"Hey, rider! In this update:\\n– you can see notifications for the active order;\\n– told a bit more about additional luggage service.\\n\\nFor any feedback or questions, email us at android@uklon.com.ua\",\n" +
                "    \"publisher_id\": \"Uklon\",\n" +
                "    \"price\": \"Free\",\n" +
                "    \"screenshot_urls\": [\n" +
                "        \"https://lh3.googleusercontent.com/ZdQMzLN5Q5j1npVv8x8qhu5F9j3x0Cs1M-RlQqS3bv7knOgvIdUs6mlsKgl0FOUihBs\",\n" +
                "        \"https://lh3.googleusercontent.com/ePxenkJZOa1wg8W_bKVg7yv1o2tYX-DdiBTiwfV9AAQJjZ00aD2qkp3XxmCG3ZYM9w\",\n" +
                "        \"https://lh3.googleusercontent.com/3zg-bWww8T-SwLVA4pMPgFIRMsm2aQaj814UVgsrq9XZokVj2RKwgSWByhraICbUcg\",\n" +
                "        \"https://lh3.googleusercontent.com/MioDgiuWURZnuvfMOwWmYMCxYmoHZGjQQNi3r8mO_jLq9f8NgGAltJ3vPvEhG55LPA\",\n" +
                "        \"https://lh3.googleusercontent.com/rvBjnju_YojjXyrJ7mgolpXW1oRosGlL8Q7-ef-YR5V0EsGnIjahCV_EOYBTl5qGias\"\n" +
                "    ],\n" +
                "    \"status\": \"updated\",\n" +
                "    \"publisher_email\": \"android@uklon.com.ua\",\n" +
                "    \"description\": \"Uklon - is a reliable car service in Ukraine (Kyiv, Odesa, Lviv, Kharkiv, Dnipro, Zaporizhia...). Instant car booking to the airport and in the town.<br><br>Advantages:<br>• instant booking, your booking is sent simultaneously to several hundred partner taxi services;<br>• loyal fares and discounts for riders;<br>• momentary recalculation of the cost according to your wishes;<br>• reliable booking in advance;<br>• history of rides and saved addresses allow to create new bookings in a few clicks;<br>• additional cost option, allows successfully request a ride in any circumstances: in the traffic hours, morning hours, at night, during a sudden worsening of weather conditions;<br>• the driver rate review allows to determine the quality of the upcoming trip before boarding;<br>• quality of our service is provided by technical support - 24/7!<br><br>Additional services<br>      • personal driver;<br>      • car types (comfort, wagon, minibus);<br>      • meeting at the airport with a sign;<br>      • english speaking driver;<br>      • driver-courier; <br>      • electronic receipt for provided services.<br><br>You can request a ride from any point of the city and the airport without calling the operator or waiting for confirmation of the order. You just need to fulfill a few fields in the application.<br><br>Online taxi booking service available in Ukraine (Kyiv, Dnipro, Kharkiv, Odesa, Lviv, Sumy and Zaporizhia).\",\n" +
                "    \"price_value\": 0.0,\n" +
                "    \"all_rating\": 4.7,\n" +
                "    \"store_url\": \"https://play.google.com/store/apps/details?id=ua.com.uklontaxi\",\n" +
                "    \"downloads\": \"1,000,000+\",\n" +
                "    \"publisher_address\": \"\",\n" +
                "    \"status_unix_timestamp\": 1571903889,\n" +
                "    \"genre\": \"Travel & Local\",\n" +
                "    \"bundle_id\": \"ua.com.uklontaxi\",\n" +
                "    \"genre_ids\": [\n" +
                "        \"TRAVEL_AND_LOCAL\"\n" +
                "    ],\n" +
                "    \"iap_price_range\": \"\",\n" +
                "    \"all_histogram\": {\n" +
                "        \"1\": 1221,\n" +
                "        \"3\": 626,\n" +
                "        \"2\": 343,\n" +
                "        \"5\": 30640,\n" +
                "        \"4\": 4059\n" +
                "    },\n" +
                "    \"release_date\": \"2013-12-25\",\n" +
                "    \"all_rating_count\": 36892,\n" +
                "    \"permissions\": [\n" +
                "        \"prevent device from sleeping\",\n" +
                "        \"view network connections\",\n" +
                "        \"read Google service configuration\",\n" +
                "        \"find accounts on the device\",\n" +
                "        \"full network access\",\n" +
                "        \"directly call phone numbers\",\n" +
                "        \"receive data from Internet\",\n" +
                "        \"run at startup\",\n" +
                "        \"control vibration\",\n" +
                "        \"read your contacts\",\n" +
                "        \"modify or delete the contents of your USB storage\",\n" +
                "        \"read the contents of your USB storage\",\n" +
                "        \"take pictures and videos\",\n" +
                "        \"view Wi-Fi connections\",\n" +
                "        \"read phone status and identity\",\n" +
                "        \"precise location (GPS and network-based)\",\n" +
                "        \"approximate location (network-based)\"\n" +
                "    ],\n" +
                "    \"status_date\": \"October 24, 2019\",\n" +
                "    \"genre_id\": \"TRAVEL_AND_LOCAL\"\n" +
                "}"
    }
}