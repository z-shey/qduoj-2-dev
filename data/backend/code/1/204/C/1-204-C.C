#include <stdio.h>

// 函数声明
int gcd(int a, int b);
int lcm(int a, int b);

int main() {
    int num1, num2;

    // 从键盘读取两个整数
    scanf("%d %d", &num1, &num2);

    // 计算最大公约数和最小公倍数
    int greatestCommonDivisor = gcd(num1, num2);
    int leastCommonMultiple = lcm(num1, num2);

    // 输出结果
    printf("%d %d", greatestCommonDivisor, leastCommonMultiple);

    return 0;
}

// 计算最大公约数
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// 计算最小公倍数
int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
}