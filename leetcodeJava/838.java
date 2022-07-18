package leetcodeJava;

class Solution {
    public String pushDominoes(String dominoes) {
        var arr = dominoes.toCharArray();
        var last = -2;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                last = i;
            } else if (dominoes.charAt(i) == 'L') {
                int mid = (i-last)/2 + last;
                if (last == -2) mid = -1;
                if (last == -1) {
                    for (int j = i-1; j >= 0 && arr[j] != 'L'; j--) {
                        arr[j] = 'L';
                    }
                    continue;
                }
                for (int j = mid+1; j < i; j++) {
                    arr[j] = 'L';
                }
                if ((i-last) % 2 == 0 && mid != -1) arr[mid] = '.';
                last = -1;
            } else if (last != -1 && last != -2) {
                arr[i] = 'R';
            }
        }
        return String.valueOf(arr);
    }
}
