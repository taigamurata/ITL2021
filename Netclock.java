import	java.io.*;
   import	java.net.*;
   import	java.util.*;
   
   class	Netclock {
   	public static void	main(String[]	args) {
   		// 宣言。
   		ServerSocket	servsock	=	null;	// サーバ用ソケット。
   		Socket	sock;								// 読み書き用ソケット。
   		OutputStream	out;					// 出力ストリーム。
   		String	outstr;
   		int	i;
   		Date	d;
   
   		// サーバ動作。
   		try	{
   			// サーバソケットを作成する。
   			servsock	=	new	ServerSocket(6000,	300);
   
   			// 接続の待ち受けと処理の繰り返し。
   			while(true)
   			{
   				sock	=	servsock.accept();				// 接続受付。
   
   				// 出力用データを生成する。
   				d	=	new	Date();
   				outstr	=	"\n"
   								+	"Hello, this is Netclock server."
   								+	"\n"	+	d.toString()	+	"\n"
   								+	"Thank you."	+	"\n";
   
   				// データを出力する。
   				out	=	sock.getOutputStream();
   				for(i=0;	i<outstr.length();	i++)
   					out.write((int)	outstr.charAt(i));
   				out.write('\n');
   
   				// 接続終了。
   				sock.close();
   			}
   		}
   		catch	(IOException	e)	{
   			System.exit(1);
   		}
   	}
   }
   