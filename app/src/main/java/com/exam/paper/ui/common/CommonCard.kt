package com.exam.paper.ui.common

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exam.paper.R
import com.exam.paper.data.States.PdfItem
import com.exam.paper.data.States.UiState
import com.exam.paper.data.States.UiStateForCombinedPapers

val roboto= FontFamily(Font(R.font.roboto_bold))



@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun CommonCard(
    state: UiState,
    pdfItem: PdfItem,
    onCardClicked: (String) -> Unit,
    slideOffset: Animatable<Float, AnimationVector1D>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = slideOffset.value.dp)
            .padding(horizontal = 30.dp)
            .background(Color.Red)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF4E8752),
                    style = Stroke(width = 15.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx()),
                )
            }
            .clickable {
                onCardClicked.invoke(pdfItem.url)
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3D723E))
    ) {
        // Card content as before
        Column {
            Row {
                Text(
                    text = "END TERM",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, top = 7.dp),
                    fontSize = 18.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Row {
                Text(
                    text = "EXAMINATION",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, bottom = 10.dp),
                    fontSize = 25.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Divider(color = Color(0xFF4E8752), thickness = 5.dp)
            Text(
                text = "${state.sub} ${pdfItem.name}.pdf",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 7.dp).padding(start = 6.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W700,
                color = Color.White
            )
        }
    }
}





@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun CommonCard1(
    state1: UiStateForCombinedPapers,
    pdfItem: PdfItem,
    onCardClicked: (String) -> Unit,
    slideOffset: Animatable<Float, AnimationVector1D>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y=slideOffset.value.dp)
            .padding(horizontal = 30.dp)
            .background(Color.Red)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF4E8752),
                    style = Stroke(width = 15.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx()),
                )
            }
            .clickable {
                onCardClicked.invoke(pdfItem.url)

            }, colors = CardDefaults.cardColors(containerColor = Color(0xFF3D723E))
    ) {
        Column {
            Row {
                Text(
                    text = "END TERM",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp)
                        .padding(top = 7.dp),
                    fontSize = 18.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Row {
                Text(
                    text = "EXAMINATION",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, bottom = 10.dp),
                    fontSize = 25.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Divider()
            Text(
                text = "${state1.sub}.pdf",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp)
                    .padding(vertical = 7.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W700,
                color = Color.White
            )
        }
    }
}
