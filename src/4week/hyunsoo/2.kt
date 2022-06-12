package `4week`.hyunsoo

// 54분에 컷
fun main() {
    // 고객들의 가입기간이 담긴 1차원 정수 배열 periods

    // 고객들의 납부 내역을 담은 2차원 정수 배열 payments

    // 고객들의 납부 예정 금액을 담은 1차원 정수 배열 estimates

    // -- 이번 달에는 VIP가 아니지만 다음달에 VIP가 되는 고객의 수
    // + 이번 달에는 VIP지만 다음 달에는 VIP가 아니게 되는 고객의 수 를 리턴

    val periods = intArrayOf(23, 59, 59,60)

    val payments = arrayOf(
        intArrayOf(100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000),
        intArrayOf(50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000),
        intArrayOf(350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000),
        intArrayOf(50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000)
    )

    val estimates = intArrayOf(350000, 100000, 40000,50000)

    val answer = IntArray(2, { 0 })

    periods.forEachIndexed { customerIndex, customerPeriod ->

        // 이전 11개월간 납부한 금액
        val payForLast = payments[customerIndex].filterIndexed { index, it -> index != 0 }.sum()
        // 이전 12개월간 납부한 금액
        val payForLastYear = payments[customerIndex].sum()

        // 2년 미만은 VIP가 불가능
        if (customerPeriod <= 23) return@forEachIndexed
        // 2년 이상 ~ 5년 미만 - 90만원 이상을 써야지만 vip가 됨
        else if (23 <= customerPeriod && customerPeriod < 60) {

            // VIP였는지
            var wasVip =
                if (900000 <= payForLastYear && 23 < customerPeriod) true else false
            print("$customerPeriod $wasVip")
            // 과거에 VIP였을 경우 - 안 VIP가 되어야함.
            if (wasVip) {
                // 이전 11개월간 납부한 금액 + 다음날에 납부할 금액이 90만원 보다 적다면
                // VIP -> 안VIP
                if (payForLast + estimates[customerIndex] < 900000) {
                    answer[1]++
                }
            }
            // 과거에 안VIP였을 경우 - VIP가 되어야함.
            else {
                // 이전 11개월간 납부한 금액 + 다음날에 납부할 금액이 90만원이 넘는다면
                // 안VIP -> VIP
                if (900000 <= payForLast + estimates[customerIndex]) {
                    answer[0]++
                }
            }
        }

        // 5년 이상
        else {
            // VIP였는지
            val wasVip =
                if (600000 <= payForLastYear && 60 < customerPeriod ||
                    59 == customerPeriod && 900000 <= payForLastYear) true
                else false

            // 과거에 VIP였을 경우 - 안 VIP가 되어야함.
            if (wasVip){
                // 이전 11개월간 납부한 금액 + 다음날에 납부할 금액이 60만원 보다 적다면
                // VIP -> 안VIP
                if (payForLast + estimates[customerIndex] < 600000) {
                    answer[1]++
                }
            }
            // 과거에 안VIP였을 경우 - VIP가 되어야함.
            else{
                // 이전 11개월간 납부한 금액 + 다음날에 납부할 금액이 60만원이 넘는다면
                // 안VIP -> VIP
                if (600000 <= payForLast + estimates[customerIndex]) {
                    answer[0]++
                }
            }
        }
    }

    answer.forEach {
        println(it)
    }

}
