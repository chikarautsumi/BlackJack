package BlackJack;

//BlackJackゲームのクラス
public class BlackJack {
	public static void main(String[] args) {
		System.out.println("====ゲームスタート!====");
		User user = new User();
		Dealer dealer = new Dealer();

		System.out.println("Dealerはカードを2枚ずつ配布\n");

		//カードを2枚ずつ配る
		user.setCard(dealer.deal());
		dealer.setCard(dealer.deal());

		System.out.println("====ヒットフェーズ====");
		System.out.println("==Userのターン開始==");
		System.out.println("Userの手札は" + user.myCards + "、合計値は" + user.open());

		//Userは、合計値が一定以上になるまでhitを続ける
		int count = 0;
		while(user.checkSum()) {
			user.setCard(dealer.hit());
			count++;
		}
		if(count != 0) {
			System.out.println("Userはhitを" + count + "回行った");
			System.out.println("Userの手札は" + user.myCards + "、合計値は" + user.open());
		}

		System.out.println("==Userのターン終了==\n");

		//Userがバーストした場合は、Dealerの勝利でゲーム終了
		if(user.open() > 21) {
			System.out.println("Userがバーストしたので、Dealerの勝利");
			System.exit(0);
		}

		//Userがバーストしなかった場合はゲーム続行、Dealerのターン
		System.out.println("==Dealerのターン開始==");
		System.out.println("Dealerの手札は" + dealer.myCards + "、合計値は" + dealer.open());

		//Dealerは、合計値が一定以上になるまでhitを続ける
		count = 0;
		while(dealer.checkSum()) {
			dealer.setCard(dealer.hit());
			count++;
		}
		if(count != 0) {
			System.out.println("Dealerはhitを" + count + "回行った");
			System.out.println("Dealerの手札は" + dealer.myCards + "、合計値は" + dealer.open());
		}

		System.out.println("==Dealerのターン終了==\n");

		System.out.println("====スタンドフェーズ====");
		final int u_open = user.open();
		final int d_open = dealer.open();

		//Dealerがバーストした場合は、Userの勝利でゲーム終了
		//それ以外は合計値の大きさを比較し、勝敗を決定
		if(d_open > 21) {
			System.out.println("Dealerがバーストしたので、Userの勝利");
		}else if(u_open < d_open){
			System.out.println("Dealerの合計値"+ d_open + "、Userの合計値" + u_open);
			System.out.println("Dealerの勝利");
		}else if (u_open > d_open) {
			System.out.println("Dealerの合計値"+ d_open + "、Userの合計値" + u_open);
			System.out.println("Userの勝利");
		}else {
			System.out.println("Dealerの合計値"+ d_open + "、Userの合計値" + u_open);
			System.out.println("両者引き分け！");
		}
		System.out.println("ゲーム終了！");



	}
}
