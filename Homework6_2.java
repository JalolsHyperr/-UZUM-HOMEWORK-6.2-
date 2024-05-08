public class Homework6_2 {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;  // Максимальная длина монотонного подмассива
        int incLen = 1;  // Длина текущего возрастающего подмассива
        int decLen = 1;  // Длина текущего убывающего подмассива

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;        // Продлеваем возрастающий подмассив
                decLen = 1;      // Сбрасываем длину убывающего подмассива, так как тренд изменился
            } else if (nums[i] < nums[i - 1]) {
                decLen++;        // Продлеваем убывающий подмассив
                incLen = 1;      // Сбрасываем длину возрастающего подмассива, так как тренд изменился
            } else {
                incLen = 1;      // Сбрасываем оба счетчика, так как элемент равен предыдущему
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));  // Обновляем максимально найденную длину
        }

        return maxLen;
    }
}
