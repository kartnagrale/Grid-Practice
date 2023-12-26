package com.kartik.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kartik.gridapp.data.DataSource
import com.kartik.gridapp.data.Grid
import com.kartik.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp( DataSource().loadGrid() )
                }
            }
        }
    }
}

@Composable
fun GridApp( gridList : List<Grid>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ){
        items(gridList) { grid ->
            GridCard(
                grid = grid,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun GridCard(grid: Grid, modifier: Modifier=Modifier){
    Card (modifier = modifier){
        Row {
            Image(
                painter = painterResource(id = grid.imageResourceId),
                contentDescription = stringResource(id = grid.stringResourceId),
                modifier = Modifier
                    .size(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = grid.stringResourceId),
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain), 
                        contentDescription = "ic_grain",
                        modifier = Modifier
                            .padding(start = 16.dp,end = 8.dp)
                    )
                    Text(
                        text = grid.numberCourses.toString(),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun GridAppPreview() {
    GridCard(grid = Grid(R.string.photography,321,R.drawable.photography))
}
