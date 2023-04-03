//梗概：本质上是一个斐波那契数列，第n个数是前两个数之和(n>=3)，即f(n)=f(n-1)+f(n-2),n>=3;
//不过传统的fib前两个数为1，即fib = {1, 1, 2, 3, 5, 8...}，该题解法需要对传统fib的n进行处理;
//思路：这里需要用到一点动态规划的思路，假设，当我要到n = 8的楼顶时，我得先上n = 7的台阶与n = 6的台阶,
//为什么不提n = 5与n = 4的情况呢，以下两种解释可供参考：
//1.由于我一步可以走1或者2个台阶，故前者我都只需要走一步就可以到达楼顶,同时最后一步走几个台阶我是能够确定；
//2.本质上，后者已经被前者包含，即假设n = 5有a种走法，那么n = 6中最后一步走1个台阶的走法为a中，n = 7中最后一步走2个台阶的走法为a种；
//那么我们可以明白如果我们要求n个台阶的走法，得先知道n-1个台阶和n-2个台阶的走法，
//那么一直往下推，我们只需要知道1个台阶的走法和2个台阶的走法便可以求任意个台阶的走法；
//于是得到f(n) = f(n-1) + f(n-2) (n>=3)的公式

//请注意调用fib的写法n要加1，即1个台阶n = 2,2个台阶n = 3;
class Solution {
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int climbing_stairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbing_stairs(n - 1) + climbing_stairs(n - 2);
    }

    //plus
    //梗概：f(n) = f(n-1) + f(n-2) - f(n-4) (n>=5)
    //思路：还是从斐波那契数列思路入手，f(n) = f(n-1) + f(n-2)，那么出现连续走两步的情况一定出现在f(n-2)中，
    //f(n-2) = f(n-2-1) + f(n-2-2),由于连续走两步不可出现
    //故得到f(n) = f(n-1) + f(n-2) - f(n-4) (n>=5)

    public static int fib_puls(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 3;
        }
        return fib_puls(n - 1) + fib_puls(n - 2) - fib_puls(n - 4);
    }

    public static int climbing_stairs_plus(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        } else if (n == 4) {
            return 4;
        }
        return climbing_stairs_plus(n - 1) + climbing_stairs_plus(n - 2) - climbing_stairs_plus(n - 4);
    }

    public static void main(String[] args) {
        int stairs = 5;

        System.out.println(fib(stairs + 1));

        System.out.println(fib_puls(stairs + 1));

        System.out.println(climbing_stairs(stairs));

        System.out.println(climbing_stairs_plus(stairs));
    }
}

//tips:如上递归的写法对n的限制比较大，可以用数组的形式临时存储一些中间值，能够支持更大的n;
//另外，有个求斐波那契数列的通项公式，好像是能求1e9的值;
