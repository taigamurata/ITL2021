import java.io.*;
import java.net.*;

public class Readnet {
	public static void main(String[] args) {
		//変数を準備する
		//受信したメッセージを保存するための、バッファ。
		//1024byte分の、byte型の配列
		byte[] buff = new byte[1024];
		//ソケット。通信接続。
		Socket readsock = null;
		//データを流す道。入力（読み取り）用。
		InputStream instr = null;
		boolean cont = true;

		//サーバに接続する
		//ソケット作成＆データの通路をゲットする
		try {
			//接続する：args[0]:localhost args[1]:6000
			readsock = new Socket ( args[0],Integer.parseInt( args[1] ) );
			instr = readsock.getInputStream();
		} catch ( Exception e ){
			System.err.println("ネットワークエラーです。");
			System.exit(1);
		}
		//データを受信する
		while( cont ){
			try {
				//streamから、データを読む（受信する）＆buffに保存
				int n = instr.read( buff );
				//画面（標準出力）に書き込む
				System.out.write( buff , 0 , n );
			} catch ( Exception e ) {
				//例外：読み取ったデータが、ゼロ（空っぽ）。受信終わり
				cont = false;
			}
		}

		//ネットワーク接続を、閉じる
		try {
		  instr.close();
		} catch ( Exception e ){
			System.err.println("ネットワークのエラーです");
			System.exit(1);
		}

		}//mainの終わり
	}//class の終わり
