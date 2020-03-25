package BlackJack;

import java.util.ArrayList;

//BlackJackにおけるプレイヤーの動きや持ち物を抽象化したクラス
public abstract class Human {
	//手札
	protected ArrayList<Integer> myCards = new ArrayList<>();

	//合計値の算出
	public abstract int open();

	//手札にカードをセット
	public abstract void setCard(ArrayList<Integer>list);

	//hitの判断
	public abstract boolean checkSum();
}
