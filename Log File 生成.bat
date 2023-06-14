echo このプログラムはCドライブ直下にAccountBookフォルダーを作成し、その中にログを格納するログフォルダーを生成します
echo Start!

cd C:\\

mkdir AccountBook

cd C:\\AccountBook

mkdir Logs

cd C:\\AccountBook\Logs

type nul > DebugLog.txt

type nul > ErrorLog.txt

