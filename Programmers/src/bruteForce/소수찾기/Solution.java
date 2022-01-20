package bruteForce.소수찾기;

/*
    순열 + 소수판별 문제 (level 2)

    코드 리뷰
    1. 에라토스테네스의 체를 이용하여 모든 소수를 판별하는 것을 구했지만 O(Nlog(log N)) 이므로 , 일일히 소수 판별하는것보다 수행속도가 오래걸렸다.
        -> 그냥 소수 판별하는 것으로 바꾸자. (프로그래머스 모범 답안 참고)
    2. 순열을 구하는 메서드에서 소수 판별 로직까지 들어가서 메서드의 단일 책임을 위반했다.
    3. 011 11 의 중복을 피하는 방법은 HashSet을 이욯하자.
 */
class Solution {
    public int [] primeArray;
    public int answer = 0 ;

    public void calPrime(int numRange){
        primeArray[0] = 0;
        primeArray[1] = 0;
        for (int i = 2 ; i < numRange ; i++){
            primeArray[i] = 1;
        }
        for (int i = 2 ; i < Math.sqrt(numRange) ; i++){
            if (primeArray[i] == 1){
                for (int j = i*2 ; j < numRange ; j+=i){
                    primeArray[j] = 0;
                }
            }
        }
    }
    public void permutation(String prefix , String string){

        int strLen = string.length();

        if (prefix.length() != 0 && primeArray[Integer.parseInt(prefix)] == 1){
            primeArray[Integer.parseInt(prefix)] = 2;
            answer++;
        }
        for (int i = 0 ; i < strLen ; i++){
            permutation(prefix + string.charAt(i),
                    string.substring(0,i) +
                            string.substring(i+1,strLen));
        }

    }

    public int solution(String numbers) {
        int numRange = (int)Math.pow(10,numbers.length());
        this.primeArray = new int [numRange];
        this.calPrime(numRange);
        this.permutation("" , numbers);
        return this.answer;
    }


}

