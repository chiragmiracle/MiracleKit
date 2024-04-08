package com.miracle.miraclekit.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.miracle.miraclekit.Model.SnackList
import com.miracle.miraclekit.Model.snackList
import com.miracle.miraclekit.R
import com.miracle.miraclekit.theme.Clr1
import kotlin.random.Random

@SuppressLint("ModifierParameter")
@Composable
fun SnackCard(
    snack: SnackList,
    textColor: Color = remember(snack.id) { randomColor() },
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .clickable(onClick = {}),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Box(
            contentAlignment = Alignment.BottomEnd,
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = modifier,
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                placeholder(drawableResId = R.drawable.placeholder)
                            }).build()
                    ),
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        text = snack.name
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            fontSize = 14.sp,
                            text = "$${snack.price}"
                        )
                        Text(
                            fontSize = 14.sp,
                            text = "Tags: ${snack.tagline}"
                        )
                    }
                }
            }

            FavoriteButton(
                modifier = Modifier
                    .padding(20.dp),
                color = textColor,
            )
        }
    }
}

@Composable
fun HorizontalSnackCard(
    modifier: Modifier = Modifier,
    snack: SnackList,
    textColor: Color = remember(snack.id) { randomColor() },
) {
    Box(contentAlignment = Alignment.TopEnd) {

        Column {

            Image(
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { },
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(drawableResId = R.drawable.placeholder)
                        }).build()
                ),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier.padding(2.dp),
                color = textColor,
                fontWeight = FontWeight.Bold,
                text = snack.name
            )
        }

        FavoriteButton(
            modifier = Modifier
                .padding(12.dp),
            color = textColor
        )
    }
}


@Composable
fun GridSnackCard(
    modifier: Modifier = Modifier,
    snack: SnackList,
) {
    Box(contentAlignment = Alignment.TopEnd, modifier = modifier.padding(4.dp)) {


        Image(
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { },
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(drawableResId = R.drawable.placeholder)
                    }).build()
            ),
            contentDescription = null
        )
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63)
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}

@Preview
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C)
@Composable
fun SnackCardPreview() {
    val snack = snackList.first()
    SnackCard(snack = snack, Color.Black)
}

@Preview
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C)
@Composable
fun HorizontalSnackCardPreview() {
    val snack = snackList.first()
    HorizontalSnackCard(snack = snack, textColor = Color.Black)
}

@Preview
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C)
@Composable
fun FavoriteButtonPreview() {
    FavoriteButton()
}

private fun randomColor() = Color(
    Random.nextInt(255),
    Random.nextInt(255),
    Random.nextInt(255)
)