Program cript_Cezar;
uses crt;
var keya,keya_d:integer;
    s,tc:string;
    alfabet:array[0..25] of char;
    n_o,c:array[1..255] of integer;
    f,g,f1:text;

Procedure Init;
{initierea alfabetului}
var i:integer;
    x:char;
begin
 i:=0;
 for x:='A' to 'Z' do
 begin
  alfabet[i]:=x;
  inc(i);
 end;
end;
Procedure Numar_ordine(s1:string);
var i,j,k:integer;
begin
  k:=length(s1);
  for i:=1 to k do
   begin
    for j:=0 to 25 do
     if s1[i]=alfabet[j] then n_o[i]:=j;
    write(n_o[i],' ');
   end;
   writeln;
end;

Procedure Cript;
var i,k,j:integer;
begin
 k:=length(s);
 for i:=1 to k do
   c[i]:=(n_o[i]+keya) mod 26;
 tc:='';
 for i:=1 to k do
  for j:=0 to 25 do
   if c[i]=j then tc:=tc+alfabet[j];
 writeln(g,tc);
end;

Procedure Decript;
var i,k,j:integer;
begin
 k:=length(tc);
 for i:=1 to k do
   c[i]:=(n_o[i]+keya_d) mod 26;
 tc:='';
 for i:=1 to k do
  for j:=0 to 25 do
   if c[i]=j then tc:=tc+alfabet[j];
 writeln(f1,tc);
end;

Begin
 clrscr;
 write('cheia=');readln(keya);
 Init;
 assign(f,'clar.txt');reset(f);
 assign(g,'cript.txt');rewrite(g);
 while not(eof(f)) do
  begin
   readln(f,s);
   Numar_ordine(s);
   Cript;
  end;
 close(f);close(g);
 
 {Decriptarea}
 keya_d:=26-keya; 
 assign(g,'cript.txt');reset(g);

 while not(eof(g)) do
  begin
   readln(g,tc);
   Numar_ordine(tc);
   Decript;
  end;
 close(g);
 readkey;
End.