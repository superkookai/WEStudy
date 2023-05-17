package com.superkookai.westudy

class DataModel {
    var title: String?=null
    var desc: String?=null
    var photo: String?=null
    var key:String?=null
    var video: String?=null

    constructor(title: String?, desc: String?, photo: String?, key: String?, video: String?) {
        this.title = title
        this.desc = desc
        this.photo = photo
        this.key = key
        this.video = video
    }

    constructor()

    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("title", title!!)
        result.put("desc", desc!!)
        result.put("photo", photo!!)
        result.put("key", key!!)
        result.put("video", video!!)
        return result
    }

}