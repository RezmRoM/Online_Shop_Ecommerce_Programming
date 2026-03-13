import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matule.ui.theme.Accent
import com.example.matule.ui.theme.Block
import com.example.matule.ui.theme.SubTextDark
import com.example.matule.utils.AppIcons

@Composable
fun BottomBar(
    onHome: () -> Unit,
    onFavorite: () -> Unit,
    onNotification: () -> Unit,
    onProfile: () -> Unit,
    onMyCart: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = AppIcons.BackgroundBNB(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(Accent, CircleShape)
                .align(Alignment.TopCenter)
                .clickable { onMyCart() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.Bag(),
                modifier = Modifier.size(24.dp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Block)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .padding(horizontal = 31.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.clickable { onHome() },
                colorFilter = ColorFilter.tint(SubTextDark),
                painter = AppIcons.Home(),
                contentDescription = null
            )
            Image(
                modifier = Modifier.clickable { onFavorite() },
                colorFilter = ColorFilter.tint(SubTextDark),
                painter = AppIcons.HeartOutline(),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                modifier = Modifier.clickable { onNotification() },
                colorFilter = ColorFilter.tint(SubTextDark),
                painter = AppIcons.Notificaton(),
                contentDescription = null
            )
            Image(
                modifier = Modifier.clickable { onProfile() },
                colorFilter = ColorFilter.tint(SubTextDark),
                painter = AppIcons.Profile(),
                contentDescription = null
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "BottomBar"
)
@Composable
private fun BottomBarPreview() {
    BottomBar(
        onHome = { },
        onFavorite = { },
        onNotification = { },
        onProfile = { },
        onMyCart = { },
    )
}