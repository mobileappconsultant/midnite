package com.android.midnite.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.midnite.domain.model.MarketContract
import com.android.midnite.domain.model.MarketData
import com.android.midnite.ui.theme.dividerColor

@Composable
fun MarketList(marketData: List<MarketData>) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Markets", modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(16.dp))
        marketData.forEach {
            MarketListItem(marketData = it)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun MarketListItem(marketData: MarketData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = marketData.name,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            marketData.contracts.forEach {
                ContractItem(it)
            }
        }
    }
}

@Composable
fun ContractItem(contract: MarketContract) {
    Column(Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = contract.name, Modifier.weight(1f))
            Divider(Modifier.width(24.dp), thickness = 2.dp, color = MaterialTheme.colors.dividerColor)
            Text(text = contract.price, Modifier.weight(1f), textAlign = TextAlign.End)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Text(
            text = "Max Bet: ${contract.maxBet}",
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
