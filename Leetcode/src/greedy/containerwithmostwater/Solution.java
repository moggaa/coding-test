package greedy.containerwithmostwater;

/*
    그리디한 느낌은 없지만 그리디 문제.
    two pointer 양끝 아이디어만 알면 풀 수 있다.
    else문을 피하기 위한 코드 작성
 */

class Solution {
    public int maxArea(int[] height) {
        Container container = new Container(height);
        while(container.minIndex < container.maxIndex){
            container.amountUpdate();
            container.indexUpdate();
        }
        return container.maxAmount;
    }
}
class Container {
    int maxIndex;
    int minIndex;
    int maxAmount;
    int [] height;
    public Container(int[] height){
        this.height = height;
        maxIndex = height.length - 1;
        minIndex = 0;
        maxAmount = Math.min(height[minIndex],height[maxIndex])*(maxIndex-minIndex);
    }
    public void indexUpdate(){
        if (height[minIndex] <= height[maxIndex]){
            minIndex++;
            return;
        }
        maxIndex--;
    }
    public void amountUpdate(){
        int amount = Math.min(height[minIndex],height[maxIndex])*(maxIndex-minIndex);
        if (amount > maxAmount){
            maxAmount = amount;
        }
    }
}
