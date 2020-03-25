package BlackJack;

import java.util.ArrayList;

//プレイヤーであるUserの動きや持ち物を具体化したクラス
public class User extends Human{
	//合計値の算出
	@Override
	public int open() {
		//11以上のカードは10として合計値を算出
		int total = 0;
		for(int i = 0;i < myCards.size();i++) {
			if(myCards.get(i) > 10 ) {
				total += 10;
			}else {
				total += myCards.get(i);
			}
		}
		return total;
	}

	//手札にカードをセット
	@Override
	public void setCard(ArrayList<Integer> list) {
		myCards.addAll(list);
	}

	//hitの判断
	@Override
	public boolean checkSum() {
		return open() < 15;
	}

}
