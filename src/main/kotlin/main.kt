package ru.netology.mypusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message1 = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 3,
          "postContent": "Спорят дураки. Умные дискутируют. Мудрые говорят истину.\n
Если хочешь казаться умным, никогда не дискутируй с дураком, т.к. дурак ничего не поймет и всегда останется при своём, и в итоге, все превратится в спор, а спорят дураки)
"
        }""".trimIndent())
        .setToken(token)
        .build()

    val message2 = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 3,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message1)
//    FirebaseMessaging.getInstance().send(message2)
}