package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

//プレイヤーであるDealerの動きや持ち物を具体化したクラス
public class Dealer extends Human{
	ArrayList<Integer> cards = new ArrayList<>();

	//山札を作成し、カードをシャッフル
	public Dealer(){
		for(int i = 0;i < 4;i++) {
			for(int j = 1;j < 14;j++) {
				cards.add(j);
			}
		}
		Collections.shuffle(cards);
	}

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
		return open() < 17;
	}

	//カードを2枚引く
	public ArrayList<Integer> deal() {
		ArrayList<Integer> deal = new ArrayList<>();
		for(int i = 0;i < 2;i++) {
			deal.add(cards.remove(0));
		}
		return deal;
	}

	//カードを1枚引く
	public ArrayList<Integer> hit() {
		ArrayList<Integer> hit = new ArrayList<>();
		hit.add(cards.remove(0));
		return hit;
	}


}
