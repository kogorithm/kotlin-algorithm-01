package `sk인턴쉽 `

// 12:07까지
fun main(){

     val n = 5
     val plan = arrayOf(
          "100 1 3",
          "500 4",
          "2000 5"
     )
     val clients = arrayOf(
          "300 3 5",
          "1500 1",
          "100 1 3",
          "50 1 2"
     )

     val answer = IntArray(clients.size, {0})

     // 데이터 - 부가서비스
     val planData = mutableListOf<String>()
     plan.forEachIndexed { index,it ->
          // 데이터
          val data = it.split(" ")[0]
          // 부가서비스
          val addedServices = it.split(" ").filterIndexed { index, s ->
               index != 0
          }.joinToString()

          if (index == 0){
               // - 로 데이터 양과 부가서비스를 구분함.
               planData.add("$data-$addedServices")
          }
          else {
               // 이전 부가서비스도 추가해야함.
               val lastAddedService = planData[index-1].split("-")[1]
               planData.add("$data-$lastAddedService, $addedServices")
          }

     }

     clients.forEachIndexed { clientIndex, it ->
          // 유저가 원하는 데이터
          val useData = it.split(" ")[0].toInt()
          // 유저가 원하는 서비스
          val useAddedServices = it.split(" ").filterIndexed { index, s ->
               index != 0
          }

          for (index in 0 until  planData.size){
               // 요금제의 데이터
               val data = planData[index].split("-")[0].toInt()
               // 요금제에 있는 서비스
               val addedServices = planData[index].split("-")[1]
               var canUse = true

               // 원하는 데이터보다 요금제의 데이터가 적다면 스킵
               if (useData > data) continue

               useAddedServices.forEach { useService ->
                    if (!addedServices.contains(useService)) {
                         canUse = false
                    }
               }

               if (canUse){
                    answer[clientIndex] = index+1
                    break
               }
          }

     }

     answer.forEach {
          println(it)
     }

}