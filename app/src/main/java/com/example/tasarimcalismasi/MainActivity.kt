package com.example.tasarimcalismasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tasarimcalismasi.ui.theme.AnaRenk
import com.example.tasarimcalismasi.ui.theme.TasarimCalismasiTheme
import com.example.tasarimcalismasi.ui.theme.YaziRenk1
import com.example.tasarimcalismasi.ui.theme.YaziRenk2
import com.example.tasarimcalismasi.ui.theme.pacifico
import androidx.compose.ui.unit.dp
import com.example.tasarimcalismasi.ui.theme.AnaRenkDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TasarimCalismasiTheme {
                Anasayfa()
            }
        }
    }
}


//res klasörü resource kaynak demekyir buralardaki klasörlere bir şeyler eklemek isteyebiliriz, klasöz ya da dosya isimleri küçük harfle olamk zorunda ve boşluk yok

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//dark tema ise true değilse false bilgiisni almak için burayı ekledik, şimdi color.kt'deki dark theme renklerni eklediğimiz yerlerde dark tema olunca otomatik o renkleri çekecektir
fun Anasayfa(darkTheme:Boolean = isSystemInDarkTheme()){
    //çoklu ekran ayarı için o an çalışılan ekran yükseklik genişlik öğrenerek işlem yapılır, sonra o da kendi ayarlar
    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp
    val ekranGenisligi = configuration.screenWidthDp


    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text= "Pizza", fontFamily = pacifico) },
            colors = TopAppBarDefaults.topAppBarColors(
                //dark theme kullanma örneği burada
                containerColor = if(darkTheme) AnaRenkDark else AnaRenk,
                titleContentColor = YaziRenk1
            )
        )
    }) {
        paddingValues ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.pizzaBaslik), color = AnaRenk, fontWeight = FontWeight.Bold, fontSize = (ekranGenisligi/10).sp) //36.sp idi eski ayar çoklu ekran ayarı için yukarda tanımlanan şeyleri burada kulanacağız
                Image(painter = painterResource(id = R.drawable.yemek_resim), contentDescription = "")
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    MyChip(stringResource(id = R.string.peynirYazi))
                    MyChip(stringResource(id = R.string.sucukYazi))
                    MyChip(stringResource(id = R.string.zeytinYazi))
                    MyChip(stringResource(id = R.string.biberYazi))
                }

                Text(text = stringResource(id = R.string.teslimatSure), color = YaziRenk2, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Text(text = stringResource(id = R.string.teslimatBaslik), color = AnaRenk, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Text(text = stringResource(id = R.string.pizzaAciklama),
                    color = YaziRenk2, fontSize = 22.sp, textAlign = TextAlign.Center)

                //horizontal kısmına spaceevnly dersek araya boşluk verir, ama spacebetween dersek sağa sola tamamn yaslayarak araya boşluk koyar, sağ soldan da padding vererek ayarlarız
                //padding için all (üst alt sağ sol: tüm kenarlar) her yerden demek (yazılarda sp ama kalanda dp kullanılır
                //left = start (android) = leading (ios)
                //right = end = trailing
                Row (modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.fiyatYazi), color = AnaRenk, fontWeight = FontWeight.Bold, fontSize = 44.sp)
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AnaRenk,
                            contentColor = YaziRenk1
                        )
                    ) {
                        Text(text = stringResource(id = R.string.buttonYazi), fontSize = 18.sp)
                    }
                }

        }

    }
}

//yazılar için fontsize birimi sp (standart pixel)
//spaceeevenly dikeyde arada boşluk bırakarak hizalama sağlar, diğeri de yatayda
//arrangment alignment hangiis gelirse onu yazacaksın yanına ezbere gerek yok: vertical dikey, horziantal yatay bil yeter

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    TasarimCalismasiTheme {
        Anasayfa()
    }
}



@Composable
fun MyChip(icerik:String){
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = AnaRenk,
            contentColor = YaziRenk1
        )
    ) {
        Text(text = icerik)
    }
}