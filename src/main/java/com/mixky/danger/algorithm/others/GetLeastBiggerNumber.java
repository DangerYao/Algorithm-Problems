package com.mixky.danger.algorithm.others;

public class GetLeastBiggerNumber {

	public static void main(String[] args) {
		int number1 = -1243;
		int number2 = 4231;
		
		
		System.out.println(getleastBiggerNumber(number1));
		System.out.println(getleastBiggerNumber(number2));
	}
	
	/**
	 * 考虑数字的正负以及0的处理
	 * 步骤：1、先把数字转换为char数组
	 * 	    2、从后向前比较，如果是整数且前位比后位小，交换两位，
	 * 		如果是负数，前位比后位大，则交换两位
	 *           处理完成后就直接退出循环
	 *      3、再把处理了的char数组转换成int返回
	 * @param number
	 * @return
	 */
	public static int getleastBiggerNumber(int number) {
		
		boolean sign = true;	// 正负号，true为正，false为负
		
		if(number == 0) {
			throw new RuntimeException("0没法找到最小大于它的值");
		} else if( number < 0){
			sign = false;
		}
		
		String numStr = Integer.valueOf(number).toString();
		char[] charArray = numStr.toCharArray();
		
		for(int i=charArray.length -1; i>0; i--) {
			if(sign && charArray[i] > charArray[i-1]) {
				swap(charArray, i);
				break;
			} else if(!sign && charArray[i] < charArray[i-1]) {
				swap(charArray, i);
				break;
			}
		}
		
		int result = Integer.parseInt(String.valueOf(charArray));
		
		if(result == number) {
			throw new RuntimeException("已经是最大值了");
		}
		
		return result;
	}

	private static void swap(char[] charArray, int i) {
		char temp = charArray[i];
		charArray[i] = charArray[i-1];
		charArray[i-1] = temp;
	}

}
