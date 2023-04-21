package Programmers.LV0;

class 옹알이 {
    public int solution(String[] babbling) {
        int answer = 0;

        String [] origin = {"aya", "ye", "woo", "ma"};
        String [] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
        //최대 한번씩 밖에 사용 못하므로 위에 것은 발음 하지 못하는 것이다. 따라서 따로 분리해야함

        for(String s : babbling){
            String tmp = s;

            for(String r: repeat){
                tmp = tmp.replace(r, "!");
            }
            for(String o: origin){
                tmp = tmp.replace(o," ");
                //""로 replace 하면 양 옆 문자가 붙어 오류 생기는 경우 있음
            }

            tmp = tmp.replace(" ", "");

            if(tmp.length() == 0) answer += 1;
        }
        return answer;

    }

}