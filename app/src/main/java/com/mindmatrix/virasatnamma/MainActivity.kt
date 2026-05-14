package com.mindmatrix.virasatnamma

import android.Manifest
import android.content.Intent
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.mindmatrix.virasatnamma.data.Achievement
import com.mindmatrix.virasatnamma.data.HeritageSite
import com.mindmatrix.virasatnamma.data.SiteWithState
import com.mindmatrix.virasatnamma.data.imageList
import com.mindmatrix.virasatnamma.util.ImageCompressor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.Executors
import kotlin.math.absoluteValue
import androidx.compose.ui.viewinterop.AndroidView

private val TempleStone = Color(0xFF8B4513)
private val GoldenAccent = Color(0xFFFFC107)
private val SacredOrange = Color(0xFFFF6F00)
private val DeepRed = Color(0xFF8B0000)
private val CreamWhite = Color(0xFFFFF8DC)
private val LightCream = Color(0xFFFAF0E6)
private val DarkBrown = Color(0xFF3E2723)
private val AccentGreen = Color(0xFF2E7D32)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VirasatTheme { VirasatApp() } }
    }
}

@Composable
fun VirasatTheme(content: @Composable () -> Unit) {
    val scheme = lightColorScheme(
        primary = TempleStone,
        secondary = GoldenAccent,
        tertiary = SacredOrange,
        background = CreamWhite,
        surface = LightCream,
        onPrimary = Color.White,
        onSecondary = DarkBrown,
        onSurface = DarkBrown,
    )
    MaterialTheme(colorScheme = scheme, typography = MaterialTheme.typography.copy(displaySmall = MaterialTheme.typography.displaySmall.copy(fontFamily = FontFamily.Serif)), content = content)
}

@Composable
fun VirasatApp(viewModel: AppViewModel = hiltViewModel()) {
    val nav = rememberNavController()
    val audio by viewModel.audio.collectAsState()
    val backStack by nav.currentBackStackEntryAsState()
    val current = backStack?.destination?.route.orEmpty()
    Scaffold(
        bottomBar = {
            if (current in listOf("home", "explore", "scanner", "passport", "settings")) {
                BottomNav(nav, current)
            }
        },
    ) { padding ->
        Box(Modifier.padding(padding)) {
            NavHost(navController = nav, startDestination = "splash") {
                composable("splash") { SplashScreen(nav) }
                composable("onboarding") { OnboardingScreen(nav) }
                composable("home") { HomeScreen(nav, viewModel) }
                composable("explore") { ExploreScreen(nav, viewModel) }
                composable(
                    "explore?category={category}",
                    listOf(navArgument("category") { type = NavType.StringType; defaultValue = "All" }),
                ) { ExploreScreen(nav, viewModel, it.arguments?.getString("category") ?: "All") }
                composable("scanner") { ScannerScreen(nav, viewModel) }
                composable("passport") { PassportScreen(nav, viewModel) }
                composable("settings") { ProfileScreen(nav, viewModel) }
                composable("favorites") { FavoritesScreen(nav, viewModel) }
                composable("addSite") { AddSiteScreen(nav, viewModel) }
                composable("site/{siteId}", listOf(navArgument("siteId") { type = NavType.StringType })) {
                    SiteDetailsScreen(nav, viewModel, it.arguments?.getString("siteId").orEmpty())
                }
            }
            AnimatedVisibility(audio.visible, Modifier.align(Alignment.BottomCenter)) {
                AudioSheet(audio, onPause = { viewModel.sites.value.firstOrNull { it.site.name == audio.siteName }?.site?.let { viewModel.playOrPauseAudio(it, false) } }, onClose = viewModel::stopAudio)
            }
        }
    }
}

@Composable
fun BottomNav(nav: NavController, current: String) {
    NavigationBar(containerColor = LightCream) {
        listOf(
            "home" to (Icons.Default.Home to "Home"),
            "explore" to (Icons.Default.Explore to "Explore"),
            "scanner" to (Icons.Default.QrCodeScanner to "Scan"),
            "passport" to (Icons.Default.WorkspacePremium to "Passport"),
            "settings" to (Icons.Default.AccountCircle to "Profile"),
        ).forEach { (route, pair) ->
            NavigationBarItem(
                selected = current == route,
                onClick = { nav.navigate(route) { launchSingleTop = true; popUpTo("home") { saveState = true } } },
                icon = { Icon(pair.first, pair.second) },
                label = { Text(pair.second) },
            )
        }
    }
}

@Composable
fun SplashScreen(nav: NavController) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        delay(1600)
        val prefs = context.getSharedPreferences("virasat", Context.MODE_PRIVATE)
        val first = prefs.getBoolean("firstLaunch", true)
        nav.navigate(if (first) "onboarding" else "home") { popUpTo("splash") { inclusive = true } }
    }
    Box(Modifier.fillMaxSize().background(CreamWhite), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(18.dp)) {
            MandalaMark(128.dp)
            Text("Virasat-Namma", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold, color = TempleStone)
            Text("ವಿರಾಸತ್-ನಮ್ಮ ಗೈಡ್", style = MaterialTheme.typography.titleLarge, color = DeepRed)
            LinearProgressIndicator(Modifier.width(180.dp), color = GoldenAccent, trackColor = LightCream)
        }
    }
}

@Composable
fun OnboardingScreen(nav: NavController) {
    val context = LocalContext.current
    var page by remember { mutableStateOf(0) }
    val pages = listOf(
        Triple("Discover Karnataka's Hidden Gems", "ಕರ್ನಾಟಕದ ಮರೆಯಾದ ಪರಂಪರೆಯನ್ನು ಹುಡುಕಿ", Icons.Default.Map),
        Triple("Unlock Hidden Stories", "QR ಕೋಡ್ ಸ್ಕ್ಯಾನ್ ಮಾಡಿ ರಹಸ್ಯ ಕಥೆಗಳನ್ನು ಅನ್ಲಾಕ್ ಮಾಡಿ", Icons.Default.QrCodeScanner),
        Triple("Collect Your Journey", "ನಿಮ್ಮ ಡಿಜಿಟಲ್ ಟ್ರಾವೆಲ್ ಪಾಸ್‌ಪೋರ್ಟ್ ನಿರ್ಮಿಸಿ", Icons.Default.WorkspacePremium),
        Triple("Choose, Scan, Check In", "ಸ್ಥಳ, ಕ್ಯಾಮೆರಾ ಮತ್ತು ಭಾಷಾ ಆಯ್ಕೆಗಳನ್ನು ಬಳಸಬಹುದು", Icons.Default.LocationOn),
    )
    Scaffold { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(onClick = { finishOnboarding(context, nav) }) { Text("Skip") }
            }
            Spacer(Modifier.height(32.dp))
            MandalaMark(180.dp)
            Spacer(Modifier.height(36.dp))
            Icon(pages[page].third, null, Modifier.size(56.dp), tint = SacredOrange)
            Text(pages[page].first, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = TempleStone)
            Text(pages[page].second, style = MaterialTheme.typography.titleMedium, color = DeepRed, modifier = Modifier.padding(top = 8.dp))
            Spacer(Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                pages.indices.forEach { Box(Modifier.size(if (it == page) 22.dp else 10.dp, 10.dp).clip(CircleShape).background(if (it == page) TempleStone else GoldenAccent.copy(alpha = .45f))) }
            }
            Spacer(Modifier.height(20.dp))
            Button(onClick = { if (page == pages.lastIndex) finishOnboarding(context, nav) else page++ }, modifier = Modifier.fillMaxWidth()) {
                Text(if (page == pages.lastIndex) "Get Started" else "Next")
            }
        }
    }
}

private fun finishOnboarding(context: Context, nav: NavController) {
    context.getSharedPreferences("virasat", Context.MODE_PRIVATE).edit().putBoolean("firstLaunch", false).apply()
    nav.navigate("home") { popUpTo("onboarding") { inclusive = true } }
}

@Composable
fun HomeScreen(nav: NavController, vm: AppViewModel) {
    val sites by vm.sites.collectAsState()
    val progress by vm.progress.collectAsState()
    val context = LocalContext.current
    ScreenScaffold("Virasat-Namma", actions = { IconButton({ nav.navigate("settings") }) { Icon(Icons.Default.AccountCircle, null) } }) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                TempleCard {
                    Text("Namaskara, Explorer!", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    Text("ನಮಸ್ಕಾರ, ಪರಂಪರೆ ಅನ್ವೇಷಕರೇ", color = DeepRed)
                    Spacer(Modifier.height(12.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Stat("Visits", progress?.totalVisits ?: 0)
                        Stat("Sites", progress?.sitesVisited ?: 0)
                        Stat("Facts", progress?.hiddenFactsUnlocked ?: 0)
                    }
                    LinearProgressIndicator((progress?.sitesVisited ?: 0) / 12f, Modifier.fillMaxWidth().padding(top = 12.dp), color = GoldenAccent)
                }
            }
            item {
                LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.height(220.dp), horizontalArrangement = Arrangement.spacedBy(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    item { QuickAction("Nearby", Icons.Default.Map) { openGoogleMapsSearch(context, googleMapsQueryForCategory("Temple")) } }
                    item { QuickAction("Scan", Icons.Default.QrCodeScanner) { nav.navigate("scanner") } }
                    item { QuickAction("Passport", Icons.Default.WorkspacePremium) { nav.navigate("passport") } }
                    item { QuickAction("Favorites", Icons.Default.Favorite) { nav.navigate("favorites") } }
                }
            }
            item { SectionTitle("Recently Visited") }
            item {
                val recent = sites.filter { it.isVisited }.take(5).ifEmpty { sites.take(5) }
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(recent) { SiteMiniCard(it, onClick = { nav.navigate("site/${it.site.siteId}") }) }
                }
            }
            item { SectionTitle("Explore Categories") }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(listOf("Temple", "Fort", "Monument")) { category ->
                        AssistChip(onClick = { nav.navigate("explore?category=$category") }, label = { Text(category) })
                    }
                }
            }
        }
    }
}

@Composable
fun ExploreScreen(nav: NavController, vm: AppViewModel, initialCategory: String = "All") {
    val sites by vm.sites.collectAsState()
    val context = LocalContext.current
    var radius by remember { mutableFloatStateOf(10f) }
    var category by remember(initialCategory) { mutableStateOf(initialCategory) }
    val filtered = sites.filter { category == "All" || it.site.category == category }.sortedBy { distanceKm(it.site) }.filter { distanceKm(it.site) <= radius || radius >= 50f }
    ScreenScaffold("Nearby Sites", back = null, actions = {
        IconButton({ openGoogleMapsSearch(context, googleMapsQueryForCategory(category)) }) { Icon(Icons.Default.Map, null) }
    }, fab = { FloatingActionButton({ nav.navigate("addSite") }, containerColor = SacredOrange) { Icon(Icons.Default.Add, null) } }) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("All", "Temple", "Fort", "Monument").forEach {
                    AssistChip(onClick = { category = it }, label = { Text(it) })
                }
            }
            Text("Radius: ${radius.toInt()} km")
            Slider(value = radius, onValueChange = { radius = it }, valueRange = 1f..50f)
            Text("Tap the map icon to open Google Maps for ${googleMapsQueryForCategory(category)}.")
            if (filtered.isEmpty()) {
                TempleCard {
                    Text("No sites found for this filter and radius.", fontWeight = FontWeight.Bold)
                    Text("Try switching to All, expanding the radius, or opening Google Maps from the map icon.", modifier = Modifier.padding(top = 6.dp))
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(filtered) { SiteRow(it, nav, vm) }
                }
            }
        }
    }
}

@Composable
fun SiteDetailsScreen(nav: NavController, vm: AppViewModel, siteId: String) {
    val state by remember(siteId) { vm.siteState(siteId) }.collectAsState()
    val site = state?.site ?: return Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Loading site...") }
    var kannada by remember { mutableStateOf(false) }
    var confirmDelete by remember { mutableStateOf(false) }
    var images by remember(site.imageUris) { mutableStateOf(site.imageList()) }
    val context = LocalContext.current
    val picker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val path = ImageCompressor.compressToInternalStorage(context, it)
            images = images + path
            vm.saveSite(site.copy(imageUris = images.joinToString("|")))
        }
    }
    ScreenScaffold(site.name, back = { nav.popBackStack() }, actions = {
        IconButton({ vm.toggleFavorite(site.siteId, state?.isFavorite != true) }) { Icon(if (state?.isFavorite == true) Icons.Default.Favorite else Icons.Default.FavoriteBorder, null) }
        IconButton({ confirmDelete = true }) { Icon(Icons.Default.Delete, null) }
    }) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item { HeroGallery(images, site.category) }
            item {
                Text(site.name, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = TempleStone)
                Text(site.nameKannada, style = MaterialTheme.typography.titleLarge, color = DeepRed)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 8.dp)) {
                    AssistChip(onClick = {}, label = { Text(site.category) })
                    AssistChip(onClick = {}, label = { Text(site.era) })
                    AssistChip(onClick = {}, label = { Text("${"%.1f".format(distanceKm(site))} km") })
                }
            }
            item {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button({ vm.playOrPauseAudio(site, kannada) }, Modifier.weight(1f)) { Icon(Icons.Default.PlayArrow, null); Text("Audio") }
                    OutlinedButton({ vm.checkIn(site.siteId) }, Modifier.weight(1f)) { Text(if (state?.isVisited == true) "Check In Again" else "Check-In") }
                }
            }
            item {
                TempleCard {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Language: ${if (kannada) "ಕನ್ನಡ" else "English"}")
                        Switch(checked = kannada, onCheckedChange = { kannada = it })
                    }
                    Text(if (kannada) site.descriptionKannada else site.description, Modifier.padding(top = 12.dp))
                }
            }
            item {
                TempleCard {
                    Text("Architectural Details", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("Era: ${site.era}")
                    Text("Significance: ${site.significance}")
                }
            }
            item {
                TempleCard {
                    Text(if (state?.hiddenUnlocked == true) "Hidden Fact Unlocked" else "Hidden Fact Locked", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text(if (state?.hiddenUnlocked == true) if (kannada) site.hiddenFactKannada else site.hiddenFact else "Scan the mock QR code at this site to reveal the special story.")
                    if (state?.hiddenUnlocked != true) Button({ nav.navigate("scanner") }, Modifier.padding(top = 8.dp)) { Text("Scan QR") }
                }
            }
            item {
                TempleCard {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Gallery", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Button({ picker.launch("image/*") }) { Icon(Icons.Default.Image, null); Text("Add") }
                    }
                    if (images.isEmpty()) Text("No uploaded images yet. Add from gallery to display compressed images here.")
                    images.forEach { path ->
                        Row(Modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(Uri.parse(path), null, Modifier.size(76.dp).clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop)
                            Text(path.substringAfterLast('/'), Modifier.weight(1f).padding(horizontal = 8.dp), maxLines = 1, overflow = TextOverflow.Ellipsis)
                            IconButton({
                                ImageCompressor.deleteIfInternal(path)
                                images = images - path
                                vm.saveSite(site.copy(imageUris = images.joinToString("|")))
                            }) { Icon(Icons.Default.Delete, null) }
                        }
                    }
                }
            }
            item { MiniLocation(site) }
        }
    }
    if (confirmDelete) AlertDialog(
        onDismissRequest = { confirmDelete = false },
        title = { Text("Delete site?") },
        text = { Text("This removes the site, check-ins, favorites, and uploaded images for it.") },
        confirmButton = { Button({ vm.deleteSite(site); confirmDelete = false; nav.navigate("explore") { popUpTo("home") } }) { Text("Delete") } },
        dismissButton = { TextButton({ confirmDelete = false }) { Text("Cancel") } },
    )
}

@Composable
fun ScannerScreen(nav: NavController, vm: AppViewModel) {
    var manual by remember { mutableStateOf("""{"type":"virasat_namma","siteId":"SITE_001","secretCode":"HIDDEN_FACT_KEY"}""") }
    var message by remember { mutableStateOf("Point camera at a Virasat-Namma QR code") }
    val onPayload: (String) -> Unit = { payload ->
        vm.validateQrAndUnlock(payload, onSuccess = { nav.navigate("site/$it") }, onError = { message = it })
    }
    ScreenScaffold("QR Scanner", back = null) {
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item { CameraScanner(onPayload, onMessage = { message = it }) }
            item { Text(message, color = if (message.contains("not", true) || message.contains("Invalid", true)) DeepRed else AccentGreen) }
            item {
                TempleCard {
                    Text("Mock QR Test", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    OutlinedTextField(manual, { manual = it }, Modifier.fillMaxWidth(), minLines = 3, label = { Text("QR JSON") })
                    Button({ onPayload(manual) }, Modifier.padding(top = 8.dp)) { Text("Validate and Unlock") }
                }
            }
        }
    }
}

@Composable
fun PassportScreen(nav: NavController, vm: AppViewModel) {
    val history by vm.history.collectAsState()
    val progress by vm.progress.collectAsState()
    val achievements by vm.achievements.collectAsState()
    ScreenScaffold("My Travel Pass", back = null) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item {
                TempleCard {
                    Text("Digital Passport", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Stat("Sites", progress?.sitesVisited ?: 0)
                        Stat("Facts", progress?.hiddenFactsUnlocked ?: 0)
                        Stat("Visits", progress?.totalVisits ?: 0)
                    }
                    Text("Level: ${if ((progress?.sitesVisited ?: 0) > 8) "Heritage Explorer" else "Curious Traveller"}", color = DeepRed)
                }
            }
            item { SectionTitle("Achievements") }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(Achievement.entries) { ach ->
                        val unlocked = achievements.any { it.achievementId == ach.id }
                        TempleCard(Modifier.width(160.dp)) {
                            Icon(Icons.Default.Star, null, tint = if (unlocked) GoldenAccent else Color.Gray)
                            Text(ach.titleEn, fontWeight = FontWeight.Bold)
                            Text(if (unlocked) "Unlocked" else "Locked", color = if (unlocked) AccentGreen else Color.Gray)
                        }
                    }
                }
            }
            item { SectionTitle("Visit History") }
            if (history.isEmpty()) item { Text("No check-ins yet. Explore a site and tap Check-In.") }
            items(history) { row ->
                TempleCard(Modifier.clickable { nav.navigate("site/${row.site.siteId}") }) {
                    Text(row.site.name, fontWeight = FontWeight.Bold)
                    Text(date(row.timestamp) + if (row.hasUnlockedHiddenFact) " • Hidden fact unlocked" else "")
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(nav: NavController, vm: AppViewModel) {
    val progress by vm.progress.collectAsState()
    var editing by remember { mutableStateOf(false) }
    var displayName by remember { mutableStateOf("") }
    var placeFrom by remember { mutableStateOf("") }
    var nameDraft by remember { mutableStateOf("") }
    var placeDraft by remember { mutableStateOf("") }
    var dark by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    LaunchedEffect(progress) {
        if (!editing) {
            displayName = progress?.displayName.orEmpty()
            placeFrom = progress?.placeFrom.orEmpty()
            nameDraft = displayName
            placeDraft = placeFrom
        }
    }
    ScreenScaffold("Profile", back = null) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item {
                TempleCard {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Your Profile", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        if (!editing) {
                            OutlinedButton({ editing = true }) { Icon(Icons.Default.Edit, null); Spacer(Modifier.width(6.dp)); Text("Edit") }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Box(Modifier.size(64.dp).clip(CircleShape).background(TempleStone.copy(alpha = .14f)), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.AccountCircle, null, tint = TempleStone, modifier = Modifier.size(42.dp))
                        }
                        Column(Modifier.weight(1f)) {
                            if (editing) {
                                TextField(
                                    value = nameDraft,
                                    onValueChange = { nameDraft = it },
                                    modifier = Modifier.fillMaxWidth(),
                                    singleLine = true,
                                    label = { Text("Name") },
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                )
                                TextField(
                                    value = placeDraft,
                                    onValueChange = { placeDraft = it },
                                    modifier = Modifier.fillMaxWidth(),
                                    singleLine = true,
                                    label = { Text("Place from") },
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                )
                            } else {
                                Text((displayName.takeIf { it.isNotBlank() } ?: "Your Name"), style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = TempleStone)
                                Text((placeFrom.takeIf { it.isNotBlank() } ?: "Add where you are from"), color = DeepRed)
                            }
                        }
                    }
                    if (editing) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            OutlinedButton(
                                onClick = {
                                    editing = false
                                    nameDraft = displayName
                                    placeDraft = placeFrom
                                },
                                modifier = Modifier.weight(1f),
                            ) { Icon(Icons.Default.Close, null); Spacer(Modifier.width(6.dp)); Text("Cancel") }
                            Button(
                                onClick = {
                                    displayName = nameDraft.trim()
                                    placeFrom = placeDraft.trim()
                                    vm.updateProfile(nameDraft, placeDraft)
                                    editing = false
                                },
                                modifier = Modifier.weight(1f),
                            ) { Icon(Icons.Default.Check, null); Spacer(Modifier.width(6.dp)); Text("Save") }
                        }
                    }
                }
            }
            item {
                TempleCard {
                    Text("Profile Stats", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Stat("Visits", progress?.totalVisits ?: 0)
                        Stat("Sites", progress?.sitesVisited ?: 0)
                        Stat("Facts", progress?.hiddenFactsUnlocked ?: 0)
                    }
                }
            }
            item {
                TempleCard {
                    Text("Preferences", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Language: ${if (progress?.favoriteLanguage == "kn") "ಕನ್ನಡ" else "English"}")
                        Button({ vm.setLanguage(if (progress?.favoriteLanguage == "kn") "en" else "kn") }) { Text("Switch") }
                    }
                    ToggleRow("Dark theme preview", dark) { dark = it }
                    ToggleRow("Notifications", notifications) { notifications = it }
                }
            }
        }
    }
}

@Composable
fun FavoritesScreen(nav: NavController, vm: AppViewModel) {
    val favorites by vm.favorites.collectAsState()
    ScreenScaffold("Favorites", back = { nav.popBackStack() }) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            item { Text("${favorites.size} saved sites", style = MaterialTheme.typography.titleMedium) }
            if (favorites.isEmpty()) item {
                TempleCard {
                    Text("No favorites yet", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Button({ nav.navigate("explore") }) { Text("Explore Sites") }
                }
            }
            items(favorites) { site ->
                TempleCard(Modifier.clickable { nav.navigate("site/${site.siteId}") }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        SitePlaceholder(site.category, Modifier.size(72.dp))
                        Column(Modifier.weight(1f).padding(horizontal = 12.dp)) {
                            Text(site.name, fontWeight = FontWeight.Bold)
                            Text("${site.category} • ${"%.1f".format(distanceKm(site))} km")
                        }
                        IconButton({ vm.toggleFavorite(site.siteId, false) }) { Icon(Icons.Default.Delete, null) }
                    }
                }
            }
        }
    }
}

@Composable
fun AddSiteScreen(nav: NavController, vm: AppViewModel) {
    val context = LocalContext.current
    val images = remember { mutableStateListOf<String>() }
    var name by remember { mutableStateOf("") }
    var nameKn by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    var descKn by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Temple") }
    var era by remember { mutableStateOf("") }
    var fact by remember { mutableStateOf("") }
    val picker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { images += ImageCompressor.compressToInternalStorage(context, it) }
    }
    ScreenScaffold("Add Heritage Site", back = { nav.popBackStack() }) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            item { OutlinedTextField(name, { name = it }, Modifier.fillMaxWidth(), label = { Text("Name") }) }
            item { OutlinedTextField(nameKn, { nameKn = it }, Modifier.fillMaxWidth(), label = { Text("Kannada name") }) }
            item { OutlinedTextField(desc, { desc = it }, Modifier.fillMaxWidth(), label = { Text("Description") }, minLines = 3) }
            item { OutlinedTextField(descKn, { descKn = it }, Modifier.fillMaxWidth(), label = { Text("Kannada description") }, minLines = 2) }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("Temple", "Fort", "Monument").forEach { AssistChip(onClick = { category = it }, label = { Text(it) }) }
                }
            }
            item { OutlinedTextField(era, { era = it }, Modifier.fillMaxWidth(), label = { Text("Era") }) }
            item { OutlinedTextField(fact, { fact = it }, Modifier.fillMaxWidth(), label = { Text("Hidden fact") }, minLines = 2) }
            item {
                TempleCard {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Images (${images.size})")
                        Button({ picker.launch("image/*") }) { Icon(Icons.Default.Add, null); Text("Add") }
                    }
                    images.forEach { path ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(Uri.parse(path), null, Modifier.size(64.dp).clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop)
                            Text(path.substringAfterLast('/'), Modifier.weight(1f).padding(8.dp), maxLines = 1)
                            IconButton({ ImageCompressor.deleteIfInternal(path); images.remove(path) }) { Icon(Icons.Default.Delete, null) }
                        }
                    }
                }
            }
            item {
                Button(
                    enabled = name.isNotBlank() && desc.isNotBlank(),
                    onClick = {
                        val id = "USER_${System.currentTimeMillis()}"
                        vm.saveSite(HeritageSite(id, name, nameKn.ifBlank { name }, desc, descKn.ifBlank { desc }, 12.9716 + (name.hashCode() % 100) / 1000.0, 77.5946 + (name.hashCode().absoluteValue % 100) / 1000.0, null, null, images.joinToString("|"), fact.ifBlank { "A locally added story awaits verification." }, fact.ifBlank { "ಸ್ಥಳೀಯವಾಗಿ ಸೇರಿಸಲಾದ ಕಥೆ." }, category, era.ifBlank { "Unknown era" }, "Community added hidden gem", true))
                        nav.navigate("site/$id") { popUpTo("explore") }
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) { Text("Save Site") }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenScaffold(title: String, back: (() -> Unit)? = null, actions: @Composable () -> Unit = {}, fab: @Composable () -> Unit = {}, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = { if (back != null) IconButton(back) { Icon(Icons.Default.ArrowBack, null) } },
                actions = { actions() },
            )
        },
        floatingActionButton = fab,
        containerColor = CreamWhite,
    ) { padding -> Box(Modifier.padding(padding)) { content() } }
}

@Composable
fun TempleCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier.fillMaxWidth(), shape = CutCornerShape(topStart = 18.dp, topEnd = 18.dp, bottomStart = 8.dp, bottomEnd = 8.dp), colors = CardDefaults.cardColors(containerColor = LightCream), elevation = CardDefaults.cardElevation(2.dp)) {
        Column(Modifier.padding(16.dp), content = content)
    }
}

@Composable
fun QuickAction(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    TempleCard(Modifier.clickable(onClick = onClick)) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(icon, label, Modifier.size(38.dp), tint = SacredOrange)
                Text(label, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SiteRow(row: SiteWithState, nav: NavController, vm: AppViewModel) {
    val site = row.site
    TempleCard(Modifier.clickable { nav.navigate("site/${site.siteId}") }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SiteImage(site, Modifier.size(92.dp))
            Column(Modifier.weight(1f).padding(horizontal = 12.dp)) {
                Text(site.name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(site.nameKannada, color = DeepRed, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text("${site.category} • ${"%.1f".format(distanceKm(site))} km • ${site.era}", style = MaterialTheme.typography.bodySmall)
                Text(site.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
                if (row.isVisited) Text("Visited${if (row.hiddenUnlocked) " • Hidden fact unlocked" else ""}", color = AccentGreen)
            }
            IconButton({ vm.toggleFavorite(site.siteId, !row.isFavorite) }) { Icon(if (row.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, null, tint = DeepRed) }
        }
    }
}

@Composable
fun SiteMiniCard(row: SiteWithState, onClick: () -> Unit) {
    TempleCard(Modifier.width(210.dp).clickable(onClick = onClick)) {
        SiteImage(row.site, Modifier.fillMaxWidth().height(95.dp))
        Text(row.site.name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(row.site.category)
    }
}

@Composable
fun SiteImage(site: HeritageSite, modifier: Modifier) {
    val first = site.imageList().firstOrNull()
    if (first == null) SitePlaceholder(site.category, modifier) else AsyncImage(Uri.parse(first), null, modifier.clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop)
}

@Composable
fun SitePlaceholder(category: String, modifier: Modifier) {
    Box(modifier.clip(RoundedCornerShape(8.dp)).background(TempleStone.copy(alpha = .16f)), contentAlignment = Alignment.Center) {
        Icon(if (category == "Fort") Icons.Default.Map else Icons.Default.LocationOn, null, Modifier.size(34.dp), tint = TempleStone)
    }
}

@Composable
fun HeroGallery(images: List<String>, category: String) {
    if (images.isEmpty()) SitePlaceholder(category, Modifier.fillMaxWidth().height(220.dp)) else LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(images) { AsyncImage(Uri.parse(it), null, Modifier.fillParentMaxWidth(.9f).height(220.dp).clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop) }
    }
}

@Composable
fun SimulatedMap(sites: List<SiteWithState>, nav: NavController) {
    Box(Modifier.fillMaxWidth().height(430.dp).clip(RoundedCornerShape(8.dp)).background(Color(0xFFE8F5E9))) {
        Canvas(Modifier.fillMaxSize()) {
            drawLine(TempleStone.copy(.22f), Offset(0f, size.height * .35f), Offset(size.width, size.height * .62f), strokeWidth = 10f)
            drawCircle(AccentGreen.copy(.2f), radius = size.minDimension * .35f, center = Offset(size.width * .55f, size.height * .52f), style = Stroke(4f))
        }
        Text("You", Modifier.align(Alignment.Center).background(SacredOrange, CircleShape).padding(10.dp), color = Color.White)
        sites.forEachIndexed { index, row ->
            val x = ((index * 47) % 86 + 7).dp
            val y = ((index * 71) % 330 + 25).dp
            Column(Modifier.padding(start = x, top = y).clickable { nav.navigate("site/${row.site.siteId}") }, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.LocationOn, null, tint = DeepRed, modifier = Modifier.size(34.dp))
                Text(row.site.name.take(10), style = MaterialTheme.typography.labelSmall, color = DarkBrown)
            }
        }
    }
}

@Composable
fun MiniLocation(site: HeritageSite) {
    TempleCard {
        Text("Location Map", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Box(Modifier.fillMaxWidth().height(140.dp).clip(RoundedCornerShape(8.dp)).background(Color(0xFFE8F5E9)), contentAlignment = Alignment.Center) {
            Icon(Icons.Default.LocationOn, null, Modifier.size(44.dp), tint = DeepRed)
            Text("${site.latitude}, ${site.longitude}", Modifier.align(Alignment.BottomCenter).padding(8.dp))
        }
    }
}

@Composable
fun CameraScanner(onPayload: (String) -> Unit, onMessage: (String) -> Unit) {
    val context = LocalContext.current
    var granted by remember { mutableStateOf(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        granted = it
        onMessage(if (it) "Camera ready" else "Camera permission denied")
    }
    val scanner = remember { BarcodeScanning.getClient() }
    val executor = remember { Executors.newSingleThreadExecutor() }

    DisposableEffect(Unit) {
        onDispose {
            executor.shutdown()
            scanner.close()
        }
    }

    TempleCard {
        if (!granted) {
            Text("Camera permission is needed for live QR scanning.")
            Button({ launcher.launch(Manifest.permission.CAMERA) }, Modifier.padding(top = 8.dp)) { Text("Allow Camera") }
        } else {
            Text("Point the camera at a Virasat-Namma QR code.")
            Box(Modifier.fillMaxWidth().aspectRatio(1f).clip(RoundedCornerShape(8.dp))) {
                MLKitPreview(scanner, executor, onPayload, onMessage)
                Canvas(Modifier.fillMaxSize().padding(42.dp)) {
                    val path = Path().apply {
                        moveTo(0f, 50f); lineTo(0f, 0f); lineTo(50f, 0f)
                        moveTo(size.width - 50f, 0f); lineTo(size.width, 0f); lineTo(size.width, 50f)
                        moveTo(size.width, size.height - 50f); lineTo(size.width, size.height); lineTo(size.width - 50f, size.height)
                        moveTo(50f, size.height); lineTo(0f, size.height); lineTo(0f, size.height - 50f)
                    }
                    drawPath(path, GoldenAccent, style = Stroke(8f))
                }
            }
        }
    }
}

@Composable
@Suppress("UnsafeOptInUsageError")
fun MLKitPreview(
    scanner: com.google.mlkit.vision.barcode.BarcodeScanner,
    executor: java.util.concurrent.ExecutorService,
    onPayload: (String) -> Unit,
    onMessage: (String) -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val consumed = remember { java.util.concurrent.atomic.AtomicBoolean(false) }

    AndroidView(factory = { viewContext ->
        val view = PreviewView(viewContext)
        val providerFuture = ProcessCameraProvider.getInstance(viewContext)
        providerFuture.addListener({
            val provider = providerFuture.get()
            val preview = Preview.Builder().build().also { it.setSurfaceProvider(view.surfaceProvider) }
            val analysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
            analysis.setAnalyzer(executor) { proxy ->
                val mediaImage = proxy.image
                if (mediaImage != null && !consumed.get()) {
                    val image = InputImage.fromMediaImage(mediaImage, proxy.imageInfo.rotationDegrees)
                    scanner.process(image)
                        .addOnSuccessListener { codes ->
                            val raw = codes.firstOrNull()?.rawValue
                            if (!raw.isNullOrBlank() && consumed.compareAndSet(false, true)) {
                                onMessage("QR found")
                                onPayload(raw)
                            }
                        }
                        .addOnFailureListener { onMessage("Scanner error: ${it.message}") }
                        .addOnCompleteListener { proxy.close() }
                } else {
                    proxy.close()
                }
            }
            provider.unbindAll()
            provider.bindToLifecycle(lifecycleOwner, CameraSelector.DEFAULT_BACK_CAMERA, preview, analysis)
        }, ContextCompat.getMainExecutor(viewContext))
        view
    }, modifier = Modifier.fillMaxSize())
}

@Composable
fun AudioSheet(audio: AudioUiState, onPause: () -> Unit, onClose: () -> Unit) {
    Surface(Modifier.fillMaxWidth().padding(12.dp), shape = RoundedCornerShape(8.dp), color = DarkBrown, tonalElevation = 8.dp) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            IconButton(onPause) { Icon(if (audio.isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow, null, tint = GoldenAccent) }
            Column(Modifier.weight(1f)) {
                Text("Audio Guide", color = Color.White, fontWeight = FontWeight.Bold)
                Text("${audio.siteName} • ${audio.message}", color = LightCream, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
            TextButton(onClose) { Text("Close", color = GoldenAccent) }
        }
    }
}

@Composable
fun MandalaMark(size: androidx.compose.ui.unit.Dp) {
    Canvas(Modifier.size(size)) {
        drawCircle(TempleStone, radius = this.size.minDimension / 2.2f, style = Stroke(9f))
        drawCircle(GoldenAccent, radius = this.size.minDimension / 3.2f, style = Stroke(7f))
        repeat(16) { i ->
            val angle = Math.toRadians((i * 22.5).toDouble())
            val center = Offset(
                x = this.size.width / 2 + kotlin.math.cos(angle).toFloat() * this.size.width * .34f,
                y = this.size.height / 2 + kotlin.math.sin(angle).toFloat() * this.size.height * .34f,
            )
            drawCircle(SacredOrange, radius = this.size.minDimension * .035f, center = center)
        }
    }
}

@Composable
fun SectionTitle(text: String) = Text(text, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = TempleStone)

@Composable
fun Stat(label: String, value: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value.toString(), style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = TempleStone)
        Text(label, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun ToggleRow(label: String, value: Boolean, onChange: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(label)
        Switch(value, onChange)
    }
}

private fun distanceKm(site: HeritageSite): Double {
    val baseLat = 12.9716
    val baseLng = 77.5946
    val dx = (site.latitude - baseLat) * 111.0
    val dy = (site.longitude - baseLng) * 111.0
    return kotlin.math.sqrt(dx * dx + dy * dy)
}

private fun openGoogleMapsSearch(context: Context, query: String) {
    val safeQuery = query.ifBlank { "nearby temples" }
    val mapsIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("geo:0,0?q=${Uri.encode(safeQuery)}"),
    ).apply {
        setPackage("com.google.android.apps.maps")
    }
    val fallbackIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(safeQuery)}"),
    )
    runCatching {
        if (mapsIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapsIntent)
        } else {
            context.startActivity(fallbackIntent)
        }
    }.getOrElse {
        context.startActivity(fallbackIntent)
    }
}

private fun googleMapsQueryForCategory(category: String): String = when (category.trim().lowercase(Locale.getDefault())) {
    "temple" -> "temples near me"
    "fort" -> "forts near me"
    "monument" -> "monuments near me"
    else -> "heritage sites near me"
}

private fun date(timestamp: Long): String = SimpleDateFormat("MMM dd, yyyy • h:mm a", Locale.getDefault()).format(Date(timestamp))
