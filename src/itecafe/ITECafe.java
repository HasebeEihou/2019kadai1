package itecafe;

import java.util.Scanner;

public class ITECafe {

    public static void main(String[] args) {
        //レジにお客さんが来たらこれを使う   

        Item hotcoffee = new Item(1, "【コーヒー】", 260);

        Item tea = new Item(2, "【紅茶】", 280);

        Item icecoffee = new Item(3, "【アイスコーヒー】", 750);

        Item japantea = new Item(4, "【悪魔と天使の大戦争を休戦させるほどの「甘み」を誇るたった一つのパンケーキ】", 550);

        Item poteto = new Item(5, "【ショートケーキ】", 200);

        Item[] items = new Item[5];
        items[0] = hotcoffee;
        items[1] = tea;
        items[2] = icecoffee;
        items[3] = japantea;
        items[4] = poteto;

        Scanner scan = new Scanner(System.in);

        int inputNum; //入力された商品番号
        int kazu = 0; //入力された数量
        int okaikeiHonda;//じゃんけんコモン用
        int janken;//じゃんけん用
        int yn = 0;//YESかNO
        long nedan = 0;//合計金額
        int kaikeic = 0;
        int okaneuresii = 0; //受け取ったおかね

        while (true) {
            System.out.println("レベルの高いITcafeシステム");
            System.out.print(hotcoffee.getNo() + "" + hotcoffee.getName() + " " + hotcoffee.getPrice() + "円");
            System.out.print("   " + tea.getNo() + "" + tea.getName() + " " + tea.getPrice() + "円");
            System.out.println("   " + icecoffee.getNo() + "" + icecoffee.getName() + " " + icecoffee.getPrice() + "円");
            System.out.print(japantea.getNo() + "" + japantea.getName() + " " + japantea.getPrice() + "円");
            System.out.println("   " + poteto.getNo() + "" + poteto.getName() + " " + poteto.getPrice() + "円");
            System.out.println("お前に恨みはないが、お前は商品番号を入力することになる");

            while (true) {//番号入力
                try {
                    String inputStr;
                    inputStr = scan.next();
                    inputNum = Integer.parseInt(inputStr);

                    System.out.println(items[inputNum - 1].getNo() + ":" + items[inputNum - 1].getName() + "" + items[inputNum - 1].getPrice() + "円が入力されました");

                    break;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
                    System.out.println("入力エラー：数値を入力してください");
                }
            }
            System.out.println("数量を入力するのだ人間！さすれば魂だけは見逃してやろう！");
            while (true) {
                try {
                    String inputKazu;
                    inputKazu = scan.next();
                    kazu = Integer.parseInt(inputKazu);
                    if (kazu < 1) {
                        System.out.println("入力エラー:1以上を入力してください");
                    }
                    if (kazu >= 10) {
                        System.out.println("入力エラー:一度に買えるのは9個までです");
                    } else {
                        System.out.println(kazu + "個入力されました");

                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("入力エラー：数値を入力してください");
                }
            }
            System.out.println("入力された内容は" + inputNum + "番の" + items[inputNum - 1].getName() + "が" + kazu + "個です");
            double zei = 1.08;
            nedan += (long) (kazu * items[inputNum - 1].getPrice() * zei);

            while (true) {
                System.out.println("現在の合計金額は" + nedan + "円");
                System.out.println("他にご注文はありますか？1:完了　0:次の商品");
                try {
                    String inputyn;
                    inputyn = scan.next();
                    yn = Integer.parseInt(inputyn);
                    if (yn == 1) {
///完了（yn = 1 が１の時の処理）
                       
                        while (true) {//お金もらう
                            try {
                                System.out.println("代金をお支払いください(残り代金" + nedan + "円");
                                String inputOkane;
                                inputOkane = scan.next();
                                okaneuresii = Integer.parseInt(inputOkane);

                                System.out.println(okaneuresii + "円が入力されました");
                                if (okaneuresii > nedan) {
                                    System.out.println(okaneuresii - nedan + "円のお釣りです");
                                    nedan = 0;
                                    System.out.println("ご来店ありがとうございました");
                                    System.out.println(" ");
                                    System.out.println(" ");//改行
                                    
                                    break;
                                }
                                if (okaneuresii == nedan) {
                                    nedan = 0;
                                    System.out.println("ちょうどお預かりします");
                                    System.out.println("ご来店ありがとうございました");
                                    System.out.println(" ");
                                    System.out.println(" ");//改行
                                    break;
                                } else {
                                    System.out.println(nedan - okaneuresii + "円足りません");
                                    nedan -= okaneuresii;
                                }

                            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
                                System.out.println("入力エラー：数値を入力してください");
                            }
                        }
                    }
                    //完了（ynが0か1の時の処理）                   
                    if (yn == 0 || yn == 1) {

                        break;
                    } else {
                        //完了（ynが0か1以外の時の処理）
                        System.out.println("入力エラー:1か0を入力してください");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("入力エラー：数値を入力してください");
                }
                if (yn == 0 || yn == 1) {
                    break;
                }
            }
        }

    }

}
