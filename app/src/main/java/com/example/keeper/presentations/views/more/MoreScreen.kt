package com.example.keeper.presentations.views.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.keeper.R
import com.example.keeper.utils.extension.navigateAnim

@Composable
fun MoreScreen() {
    val navController = LocalView.current.findNavController()

    val items = listOf(
        GridItem(R.drawable.ic_launcher_foreground, "Quản lý sổ cái", R.id.walletManagerFragment),
        GridItem(R.drawable.ic_launcher_foreground, "Item 2", R.id.walletManagerFragment),
        GridItem(R.drawable.ic_launcher_foreground, "Item 3", R.id.walletManagerFragment),
        GridItem(R.drawable.ic_launcher_foreground, "Item 4", R.id.walletManagerFragment),
        GridItem(R.drawable.ic_launcher_foreground, "Item 5", R.id.walletManagerFragment),
        GridItem(R.drawable.ic_launcher_foreground, "Item 6", R.id.walletManagerFragment),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 cột
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items) { item ->
            GridItemView(item) {
                navController.navigateAnim(item.route, animType = "enter")
            }
        }
    }
}

@Composable
fun GridItemView(item: GridItem, onClick: (GridItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .clickable { onClick(item) },
        shape = RoundedCornerShape(16.dp),
        backgroundColor = colorResource(R.color.lightPink1),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.text,
                tint = Color.Unspecified,
                modifier = Modifier.size(48.dp)
            )
            Text(text = item.text, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
        }
    }

}

data class GridItem(val iconRes: Int, val text: String, val route: Int)
