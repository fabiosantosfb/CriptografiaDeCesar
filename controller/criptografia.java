package controller;

import javax.swing.JOptionPane;

public class criptografia {
	private String msgC, hexCript="", binCript="";
	private char alf[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private String alfDecimal[] = {"97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122"};
	private int contM;
	
	public criptografia(String msg, int key, boolean hide){
		if(hide){
			criptMsg(msg,key);
		}else{
			desCriptMsg(msg,key);
		}
		
	}
	public String getCript(){
		return this.msgC;
		
	}
	public String getCriptHex(){
		return this.hexCript;
	}
	public String getCriptBin(){
		return this.binCript;
	}
	protected void criptMsg(String msg, int key){
		String _msg = msg , criptMsg = "", critpDec = "";
		int i, l, alfaCont=26;//CONTAR QUANTO CARACTERE TEM DO ALFABET
		int keyI = key;
		char crpt=0;

		
		String msgFormat = _msg.replaceAll(" ","").toLowerCase();//RETIRAR ESPAÇO EM BRANCO E COLOCAR LETRAS MINUSCULA
		contM = msgFormat.length();			//CONTAR QUANTO CARACTERE TEM NA MENSSAGEM
		
		for(i=0; i<contM; i++){					//LOOP TAMANHO DA MENSAGEM			
			char caractM = msgFormat.charAt(i);	//PEGAR CARACTER DA MENSSAGEM UM DE CADA VEZ			
			
			for(l=0; l<26; l++){			//LOOP TAMANHO DO ALFABETO
				if(caractM == alf[l]){		//COMPARAÇÃO DO CARACTER DA MENSSAGEM COM DO ALFABETO
				    int rota = l+keyI;      //SABER TAMANHO DA ROTA
					while(rota>=26){		//QUEBRA DE ROTA PARA ENCAIXAR TAMANHO DO ALFABETO
						rota-=alfaCont;					
					}
					crpt=alf[rota];
					critpDec=alfDecimal[rota];//PEGANDO OS INDICE PARA DECIMAL
					criptHex(critpDec);
					criptBin(critpDec);
				}
			}
	

			criptMsg += Character.toString(crpt);//CONCATENANDO TODA FRASE	
		}
		
		this.msgC=criptMsg;
	}
	
	protected void desCriptMsg(String msg, int key){
		String _msg = msg , criptMsg = "", critpDec = "";
		int i, l, alfaCont=26;//CONTAR QUANTO CARACTERE TEM DO ALFABET
		int keyI = key;
		char crpt=0;

		
		String msgFormat = _msg.replaceAll(" ","").toLowerCase();//RETIRAR ESPAÇO EM BRANCO E COLOCAR LETRAS MINUSCULA
		contM = msgFormat.length();			//CONTAR QUANTO CARACTERE TEM NA MENSSAGEM
		
		for(i=0; i<contM; i++){					//LOOP TAMANHO DA MENSAGEM			
			char caractM = msgFormat.charAt(i);	//PEGAR CARACTER DA MENSSAGEM UM DE CADA VEZ			
			
			for(l=0; l<26; l++){			//LOOP TAMANHO DO ALFABETO
				if(caractM == alf[l]){		//COMPARAÇÃO DO CARACTER DA MENSSAGEM COM DO ALFABETO
				    int rota = l-keyI;      //SABER TAMANHO DA ROTA
					while(rota<0){		//QUEBRA DE ROTA PARA ENCAIXAR TAMANHO DO ALFABETO
						rota+=alfaCont;					
					}
					crpt=alf[rota];
					critpDec=alfDecimal[rota];//PEGANDO OS INDICE PARA DECIMAL
					criptHex(critpDec);
					criptBin(critpDec);
				}
			}
	

			criptMsg += Character.toString(crpt);//CONCATENANDO TODA FRASE	
		}
		
		this.msgC=criptMsg;
	}
	protected void criptHex(String critpDec){
		String hexCript_="";
		
			hexCript_ = Integer.toHexString(Integer.parseInt(critpDec));
			hexCript_ +=" ";
			this.hexCript += hexCript_;
	}
	protected void criptBin(String critpDec){
		String binCript_="";
		
			binCript_ +="0";
			binCript_+=Integer.toBinaryString(Integer.parseInt(critpDec));
			binCript_ +=" ";
			this.binCript += binCript_;
	}

}
