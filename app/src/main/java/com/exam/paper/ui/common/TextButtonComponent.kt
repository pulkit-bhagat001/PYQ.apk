package com.exam.paper.ui.common

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun TextButtonComponent(onclick: () -> Unit, text: String, selected: Boolean) {
//, animationSpec = tween(500)
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) Color(0xFF4E8752) else Color.Gray, animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    val textColor by animateColorAsState(
        targetValue = if (selected) Color.White else Color.Black,
         animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    val strokeColor by animateColorAsState(
        targetValue = if (selected) Color.White else Color.Transparent, animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    val strokeWidth by animateFloatAsState(
        targetValue = with(LocalDensity.current) { if (selected) 5.dp.toPx() else 0f }, animationSpec = tween(1000)
    )



    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(17.dp),
        modifier = Modifier
            .padding(5.dp)
            .drawBehind {

                drawRoundRect(
                    color = strokeColor,
                    style = Stroke(width = strokeWidth),
                    cornerRadius = CornerRadius(17.dp.toPx())
                )

            }
            .clip(RoundedCornerShape(17.dp))
            .clickable { onclick.invoke() }
           ,

        ) {
        Text(
            text = text,
            fontFamily = if (selected) roboto else roboto,
            color = textColor,
            modifier = Modifier
                .padding(8.dp)
                .padding(horizontal = 5.dp)
        )

    }
//    TextButton (
//        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
//        shape = RoundedCornerShape(17.dp),
//        onClick = {onclick.invoke()},
//        modifier = Modifier
//            .clip(RoundedCornerShape(17.dp))
//            .padding(5.dp)
//            .drawBehind {
//
//                drawRoundRect(
//                    color = strokeColor,
//                    style = Stroke(width = strokeWidth),
//                    cornerRadius = CornerRadius(strokeWidthRadius)
//                )
//
//            }.clip(RoundedCornerShape(17.dp))
//
//        ) {
//        Text(
//            text = text,
//            fontFamily = roboto,
//            color = textColor,
//            modifier = Modifier
//                .padding(8.dp)
//                .padding(horizontal = 5.dp)
//        )
//
//    }


}
//        TextButton(
//        colors = if (it) ButtonDefaults.buttonColors(containerColor = Color(0xFF4E8752)) else ButtonDefaults.buttonColors(
//            containerColor = Color.Gray
//        ), shape = RoundedCornerShape(17.dp), onClick = {onclick.invoke()},
//        modifier = Modifier.padding(5.dp).drawBehind {
//            if(it){
//                drawRoundRect(color = Color.White, style = Stroke(width = 5.dp.toPx()), cornerRadius = CornerRadius(17.dp.toPx()))
//            }
//        },
//
//    ) {
//        Text(text = text, fontFamily = if(it) roboto else FontFamily.Default,
//            color = if(it) Color.White else Color.Black, modifier = Modifier.padding(8.dp).padding(horizontal = 5.dp), fontSize = 14.sp)
//
//    } }




