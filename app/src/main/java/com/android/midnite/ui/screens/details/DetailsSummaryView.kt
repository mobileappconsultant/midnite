package com.android.midnite.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.android.midnite.ui.theme.dividerColor

@Composable
fun DetailsSummaryView(icon: ImageVector, summary: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(12.dp))
        Icon(painter = rememberVectorPainter(image = icon), contentDescription = null, Modifier.size(24.dp))
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = summary, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(12.dp))
        Divider(Modifier.fillMaxWidth(), thickness = 1.dp, color = MaterialTheme.colors.dividerColor)
    }
}
