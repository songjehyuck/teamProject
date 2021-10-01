package project;

public class dup1 {
	static int[] array1 = {0,0,0,0,0,0,0,0,0,0};
	static int[] array2 = {0,0,0,0,0,0,0,0,0,0};
	static int[] array3 = {0,0,0,0,0,0,0,0,0,0};
	int getarrayvalue1(int i) {
		return array1[i];
	}
	void setarrayvalue1(int i) {
		for(int a=0;a<10;a++) {
			if(array1[a]==0) {
				array1[a]=i;
				break;
			}
		}
	}
	int getarrayvalue2(int i) {
		return array2[i];
	}
	void setarrayvalue2(int i) {
		for(int a=0;a<10;a++) {
			if(array2[a]==0) {
				array2[a]=i;
				break;
			}
		}
	}
	int getarrayvalue3(int i) {
		return array3[i];
	}
	void setarrayvalue3(int i) {
		for(int a=0;a<10;a++) {
			if(array3[a]==0) {
				array3[a]=i;
				break;
			}
		}
	}
}
