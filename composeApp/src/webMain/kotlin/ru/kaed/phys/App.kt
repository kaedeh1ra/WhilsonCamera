package ru.kaed.phys

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import whilsoncamera.composeapp.generated.resources.Res
import whilsoncamera.composeapp.generated.resources.kamera
import whilsoncamera.composeapp.generated.resources.atom
import whilsoncamera.composeapp.generated.resources.gayger
import whilsoncamera.composeapp.generated.resources.treki
import whilsoncamera.composeapp.generated.resources.kolaider
import whilsoncamera.composeapp.generated.resources.pozitron
import whilsoncamera.composeapp.generated.resources.wilson
import kotlin.math.*
import kotlin.random.Random

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PresentationApp() {
    var currentSlide by remember { mutableStateOf(0) }

    SharedTransitionLayout(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            AnimatedContent(
                targetState = currentSlide,
                modifier = Modifier.weight(1f).fillMaxWidth(),
                transitionSpec = {
                    fadeIn(tween(500)) togetherWith fadeOut(tween(500))
                },
                label = "slide_transition"
            ) { slide ->
                when (slide) {
                    0 -> Slide1(this@SharedTransitionLayout, this)
                    1 -> Slide2(this@SharedTransitionLayout, this)
                    2 -> Slide3(this@SharedTransitionLayout, this)
                    3 -> Slide4(this@SharedTransitionLayout, this)
                    4 -> Slide5(this@SharedTransitionLayout, this)
                    5 -> Slide6(this@SharedTransitionLayout, this)
                    6 -> Slide7(this@SharedTransitionLayout, this)
                    7 -> Slide8(this@SharedTransitionLayout, this)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { if (currentSlide > 0) currentSlide-- }) { Text("Назад") }
                Text("Слайд ${currentSlide + 1} из 8", style = MaterialTheme.typography.labelLarge)
                Button(onClick = { if (currentSlide < 7) currentSlide++ }) { Text("Вперед") }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide1(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    with(sharedTransitionScope) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(key = "atom_icon"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(Res.drawable.atom),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }
            Spacer(Modifier.height(32.dp))
            Text(
                "Методы регистрации радиоактивных излучений",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                "Трековые детекторы и Камера Вильсона",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide2(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    with(sharedTransitionScope) {
        Row(Modifier.fillMaxSize().padding(32.dp)) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(key = "atom_icon"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(Res.drawable.atom),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }
            Column(modifier = Modifier.padding(start = 24.dp).weight(1f)) {
                Text(
                    "• Излучение (альфа, бета, гамма) невидимо для глаз, так как длина его волны выходит за пределы оптического диапазона.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Взаимодействие с веществом: заряженные частицы тратят свою кинетическую энергию на ионизацию (выбивание электронов) и возбуждение атомов мишени.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Газоразрядные методы (Счетчик Гейгера): фиксируют электрический ток от созданных ионов.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Сцинтилляционные: фиксируют вспышки света (фотоны), излучаемые возбужденными атомами при возврате в стабильное состояние.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Трековые детекторы: позволяют визуально зафиксировать точную геометрическую траекторию полета частицы.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(32.dp))
                Row {
                    Image(
                        painterResource(Res.drawable.gayger),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    )
                    Image(
                        painterResource(Res.drawable.treki),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide3(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    var animationTrigger by remember { mutableStateOf(false) }

    val progress by animateFloatAsState(
        targetValue = if (animationTrigger) 1f else 0f,
        animationSpec = tween(2500, easing = LinearOutSlowInEasing)
    )

    val infiniteTransition = rememberInfiniteTransition()
    val time by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(100), RepeatMode.Restart)
    )

    LaunchedEffect(Unit) { animationTrigger = true }

    Column(Modifier.fillMaxSize().padding(32.dp)) {
        Text("Что такое «треки»?", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text(
            "• Трек — это макроскопический видимый след, состоящий из тысяч капелек или пузырьков, образованных вокруг ионизированных атомов.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• Ионизирующая способность: чем больше заряд частицы и чем меньше ее скорость, тем больше времени она взаимодействует с атомами на своем пути, создавая более плотный след ионов.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• Вторичная ионизация: иногда выбитые электроны сами получают такую энергию, что могут ионизировать соседние атомы (так называемые дельта-электроны), создавая «ответвления» от основного трека.",
            style = MaterialTheme.typography.bodyLarge
        )
        Canvas(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 32.dp)) {
            time
            val w = size.width
            val h = size.height

            for (i in 1..10) {
                for (j in 1..4) {
                    drawCircle(Color.LightGray, radius = 6f, center = Offset(w * i / 11, h * j / 5))
                }
            }

            val currentX = w * progress
            for (i in 0..(progress * 50).toInt()) {
                val pastX = w * (i / 50f)
                val jitterY = Random.nextInt(-6, 6).toFloat()
                drawCircle(
                    color = Color.Blue.copy(alpha = 0.6f),
                    radius = 12f,
                    center = Offset(pastX, h / 2 + jitterY)
                )
            }

            drawCircle(Color.Red, radius = 24f, center = Offset(currentX, h / 2))
        }
    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide4(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column(Modifier.fillMaxSize().padding(32.dp)) {
        Text("Знакомство с камерой Вильсона", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            Column(Modifier.weight(1f)) {
                Text(
                    "• Изобретена в 1911 году шотландским физиком Чарльзом Вильсоном.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text("• Нобелевская премия 1927 г.", style = MaterialTheme.typography.bodyLarge)
                Text(
                    "• Устройство: стеклянный цилиндр, заполненный парами спирта или воды, и подвижный поршень.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Является первым в истории трековым детектором.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(50.dp))
                Image(
                    painterResource(Res.drawable.kamera),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }

            Box(Modifier.weight(1f).fillMaxHeight(), contentAlignment = Alignment.Center) {
                Row {
                    Image(
                        painterResource(Res.drawable.wilson),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide5(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    var step by remember { mutableStateOf(0) }

    val pistonY by animateFloatAsState(if (step > 0) 100f else 0f, tween(1000))
    val trackProgress by animateFloatAsState(
        if (step > 1) 1f else 0f,
        tween(4000, easing = LinearEasing)
    )

    Column(Modifier.fillMaxSize().padding(32.dp)) {
        Text(
            "Принцип работы: Адиабатное расширение",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(Modifier.height(16.dp))

        Text(
            "1. Адиабатное расширение: Поршень резко опускается. Газ совершает работу за счет внутренней энергии, его температура резко падает.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "2. Пересыщенный пар: Пары спирта/воды охлаждаются ниже точки росы, но не конденсируются, так как нет «центров конденсации».",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "3. Ионизация: Пролетающая частица выбивает электроны из молекул газа, оставляя цепочку ионов.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "4. Конденсация: Ионы становятся центрами притяжения для диполей воды/спирта. Возникает видимый трек из капель.",
            style = MaterialTheme.typography.bodyLarge
        )

        Row(Modifier.padding(top = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { step = 1 }) { Text("1. Опустить поршень") }
            Button(onClick = { step = 2 }) { Text("2. Запустить частицу") }
            Button(onClick = { step = 0 }) { Text("Сброс") }
        }

        Canvas(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 32.dp)) {
            val w = size.width
            val h = size.height
            val chamberBottom = h * 0.7f + pistonY

            drawRect(
                Color(0xFF1E1E1E),
                topLeft = Offset(w * 0.3f, 0f),
                size = Size(w * 0.4f, chamberBottom)
            )
            drawRect(
                Color(0xFF546E7A),
                topLeft = Offset(w * 0.3f, chamberBottom),
                size = Size(w * 0.4f, 40f)
            )

            val vaporColor =
                if (step > 0) Color(0xFF81D4FA).copy(alpha = 0.7f) else Color.DarkGray.copy(alpha = 0.5f)
            for (i in 0..100) {
                val rx = Random.nextFloat() * (w * 0.4f)
                val ry = Random.nextFloat() * chamberBottom
                drawCircle(vaporColor, radius = 3f, center = Offset(w * 0.3f + rx, ry))
            }

            if (step > 1) {
                val maxParticles = (trackProgress * 100).toInt()
                for (i in 0..maxParticles) {
                    val tx = w * 0.3f + (i * w * 0.004f)
                    val ty = h * 0.3f
                    val offsetY = Random.nextInt(-4, 4).toFloat()
                    drawCircle(Color.White, radius = 6f, center = Offset(tx, ty + offsetY))
                }

                val currentX = w * 0.3f + (maxParticles * w * 0.004f)
                drawCircle(Color.Yellow, radius = 10f, center = Offset(currentX, h * 0.3f))
                drawCircle(Color.Red, radius = 5f, center = Offset(currentX, h * 0.3f))
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide6(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val scope = rememberCoroutineScope()
    var isMagnetOn by remember { mutableStateOf(false) }

    val magnetAlpha by animateFloatAsState(
        targetValue = if (isMagnetOn) 1f else 0f,
        animationSpec = tween(1000)
    )

    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(0.5f, animationSpec = tween(2000, easing = LinearEasing))
    }
    Column(Modifier.fillMaxSize().padding(32.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "О чем могут рассказать треки?",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    scope.launch {
                        isMagnetOn = true
                        progress.animateTo(1f, animationSpec = tween(2000, easing = LinearEasing))
                    }
                },
                enabled = progress.value == 0.5f && !isMagnetOn
            ) {
                Text("Включить магнит 🧲")
            }

            Button(
                onClick = {
                    scope.launch {
                        isMagnetOn = false
                        progress.snapTo(0f)
                        progress.animateTo(0.5f, animationSpec = tween(2000, easing = LinearEasing))
                    }
                }
            ) {
                Text("Сброс / Заново")
            }
        }

        Spacer(Modifier.height(16.dp))
        Text(
            "• Альфа-частица (ядро Гелия): имеет заряд +2e и огромную массу (в 7300 раз тяжелее электрона). Она летит как пушечное ядро, почти не отклоняясь, оставляя жирный прямой трек.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• Бета-частица (электрон): легкая, заряд -1e. Легко рассеивается при столкновениях с атомами, оставляя тонкий, изломанный след.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• Сила Лоренца (F = qvB): При помещении камеры в магнитное поле на заряженную частицу действует сила Лоренца, искривляющая ее траекторию.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• По направлению изгиба определяют знак заряда (+ или -), а по радиусу кривизны (R = mv / qB) вычисляют импульс и массу частицы.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• Вектор магнитной индукции (B) направлен от нас в экран (обозначено крестиками ⊗).",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            "• По правилу левой руки сила Лоренца отклоняет положительный заряд вверх, а отрицательный — вниз.",
            style = MaterialTheme.typography.bodyLarge
        )

        Canvas(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 32.dp)) {
            val w = size.width
            val h = size.height

            if (magnetAlpha > 0f) {
                val cols = 12
                val rows = 6
                for (i in 0..cols) {
                    for (j in 0..rows) {
                        val cx = w * (i / cols.toFloat())
                        val cy = h * (j / rows.toFloat())
                        val crossSize = 8f
                        val fieldColor =
                            Color(0xFF00BCD4).copy(alpha = magnetAlpha * 0.4f)

                        drawLine(
                            fieldColor,
                            Offset(cx - crossSize, cy - crossSize),
                            Offset(cx + crossSize, cy + crossSize),
                            strokeWidth = 2f
                        )
                        drawLine(
                            fieldColor,
                            Offset(cx - crossSize, cy + crossSize),
                            Offset(cx + crossSize, cy - crossSize),
                            strokeWidth = 2f
                        )
                        drawCircle(
                            fieldColor,
                            radius = crossSize * 1.5f,
                            center = Offset(cx, cy),
                            style = Stroke(width = 1f)
                        )
                    }
                }
            }

            var alphaPath = Path().apply { moveTo(w * 0.1f, h * 0.3f) }
            for (i in 0..(progress.value * 100).toInt()) {
                val t = i / 100f
                val x = w * 0.1f + (w * 0.8f * t)

                val y = if (t <= 0.5f || !isMagnetOn) {
                    h * 0.3f
                } else {
                    val delta = t - 0.5f
                    h * 0.3f - (delta * delta * 500f)
                }
                alphaPath.lineTo(x, y)
            }
            drawPath(alphaPath, color = Color.Red, style = Stroke(width = 18f))

            var betaPath = Path().apply { moveTo(w * 0.1f, h * 0.7f) }
            for (i in 0..(progress.value * 100).toInt()) {
                val t = i / 100f
                val x = w * 0.1f + (w * 0.8f * t)

                val y = if (t <= 0.5f || !isMagnetOn) {
                    h * 0.7f + (sin(t * 80f) * 20f)
                } else {
                    val baseY = h * 0.7f + (sin(0.5f * 80f) * 20f)
                    val delta = t - 0.5f
                    baseY + (delta * delta * 1200f)
                }
                betaPath.lineTo(x, y)
            }
            drawPath(betaPath, color = Color.Blue, style = Stroke(width = 4f))
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide7(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column(Modifier.fillMaxSize().padding(32.dp)) {
        Text("Плюсы и минусы камеры Вильсона", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            Column(Modifier.weight(1f)) {
                Text(
                    "Достоинства:",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF4CAF50)
                )
                Text("• Невероятная наглядность.", style = MaterialTheme.typography.bodyLarge)
                Text(
                    "• Позволила совершить важнейшие открытия (например, открыт позитрон).",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(Modifier.height(24.dp))

                Text(
                    "Недостатки:",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFF44336)
                )
                Text(
                    "• Огромное «мертвое время»: после каждого расширения требуется время на очистку камеры от старых ионов электрическим полем и восстановление термодинамического баланса.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Низкая плотность мишени: так как внутри газ, частицы высоких энергий пролетают его насквозь, не успевая закрутиться в магнитном поле или столкнуться с ядрами.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(Modifier.height(24.dp))

                Text(
                    "Эволюция (Пузырьковая камера):",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF2196F3)
                )
                Text(
                    "• Чтобы решить проблему низкой плотности, в 1952 году Дональд Глазер изобрел пузырьковую камеру.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• В ней используется не пересыщенный пар, а перегретая жидкость (часто жидкий водород).",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "• Трек в ней — это след из пузырьков закипевшей жидкости. За это Глазер получил Нобелевскую премию.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Box(Modifier.weight(1f).fillMaxHeight(), contentAlignment = Alignment.Center) {
                Image(
                    painterResource(Res.drawable.pozitron),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Slide8(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    with(sharedTransitionScope) {
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(key = "atom_icon"),
                        animatedVisibilityScope = animatedVisibilityScope
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(Res.drawable.atom),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }

            Spacer(Modifier.height(32.dp))
            Text("Заключение", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))

            Text(
                "• Трековые методы позволили физикам заглянуть внутрь микромира.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Text(
                "• Камера Вильсона — исторический прорыв, открывший эпоху физики элементарных частиц.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Text(
                "• Сегодня используются современные цифровые детекторы, но принцип остался неизменным.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(32.dp))
            Image(
                painterResource(Res.drawable.kolaider),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        }
    }
}