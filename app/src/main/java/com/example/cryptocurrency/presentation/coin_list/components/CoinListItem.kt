package com.example.cryptocurrency.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency.Greeting
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick:(coin:Coin)->Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(coin) }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
        style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)

        Text(text =  if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(CenterVertically
            ),
            textAlign = TextAlign.End

        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   Row() {
       
   }
}