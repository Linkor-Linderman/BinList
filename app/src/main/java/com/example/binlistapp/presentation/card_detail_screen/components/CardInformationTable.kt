package com.example.binlistapp.presentation.card_detail_screen.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlistapp.domain.model.CardDetail
import com.google.accompanist.flowlayout.FlowRow

@Preview
@Composable
fun CardInformationTable(
    modifier: Modifier = Modifier,
    cardDetail: CardDetail = CardDetail(
        bank = null,
        brand = null,
        number = null,
        prepaid = null,
        scheme = null,
        type = null,
        country = null
    ),
) {
    val uriHandler = LocalUriHandler.current
    val ctx = LocalContext.current
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SCHEME/NETWORK: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.scheme.isNullOrBlank()) "?" else cardDetail.scheme,
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "BRAND: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.brand.isNullOrBlank()) "?" else cardDetail.brand,
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "CARD NUMBER: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text =
                    if (cardDetail.number?.length == null) {
                        "? "
                    } else {
                        "LENGTH = ${cardDetail.number.length} "
                    },
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
                Text(
                    text =
                    if (cardDetail.number?.luhn == null) {
                        "? "
                    } else {
                        "LUHN = " + if (cardDetail.number.luhn) "Yes" else "No"
                    },
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "TYPE: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.type.isNullOrBlank()) "?" else cardDetail.type,
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PREPAID: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.prepaid == null) "?" else {
                        if (cardDetail.prepaid) "Yes" else "No"
                    },
                    style = MaterialTheme.typography.h5,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "COUNTRY: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.country == null) "?" else "${cardDetail.country.emoji} ${cardDetail.country.name} " +
                            "(latitude: ${cardDetail.country.latitude}, longitude: ${cardDetail.country.longitude})",
                    style = MaterialTheme.typography.h5,
                    color = if (cardDetail.country == null) Color.Green else Color.Cyan,
                    modifier = Modifier.clickable {
                        if (cardDetail.country?.latitude != null && cardDetail.country.longitude != null) {
                            uriHandler.openUri("https://www.google.com/maps/place/" + "${cardDetail.country.latitude} ${cardDetail.country.longitude}")
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "BANK: ",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = if (cardDetail.bank?.city == null && cardDetail.bank?.name == null) "? "
                    else {
                        if (cardDetail.bank.name != null) "${cardDetail.bank.name} " else "" +
                                if (cardDetail.bank.city != null) "${cardDetail.bank.city} " else ""
                    },
                    style = MaterialTheme.typography.h5,
                    color = if (cardDetail.bank?.city == null && cardDetail.bank?.name == null) Color.Green else Color.Cyan,

                    )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (cardDetail.bank?.url == null) "? " else "${cardDetail.bank.url} ",
                    style = MaterialTheme.typography.h5,
                    color = if (cardDetail.bank?.url == null) Color.Green else Color.Cyan,
                    modifier = Modifier.clickable {
                        if (cardDetail.bank?.url != null) {
                            val urlIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://" + cardDetail.bank.url)
                            )
                            ctx.startActivity(urlIntent)
                        }
                    }
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (cardDetail.bank?.phone == null) "? " else cardDetail.bank.phone,
                    style = MaterialTheme.typography.h5,
                    color = if (cardDetail.bank?.phone == null) Color.Green else Color.Cyan,
                    modifier = Modifier.clickable {
                        if (cardDetail.bank?.phone != null) {
                            val u = Uri.parse("tel:" + cardDetail.bank.phone)
                            val i = Intent(Intent.ACTION_DIAL, u)
                            try {
                                ctx.startActivity(i)
                            } catch (s: SecurityException) {
                                Toast.makeText(ctx, "An error occurred", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                )
            }
        }
    }
}