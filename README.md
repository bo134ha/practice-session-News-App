# 📰 News App – Practice Session Task

A modern Android News application designed to practice:

* **Clean Architecture**
* **MVVM Pattern**
* **Kotlin Flow & StateFlow**
* **Jetpack Compose State Management**

> 🧩 The UI is already implemented — your task is to **connect the layers and implement the logic only**.

---

# 📂 Project Structure

```id="w3k91a"
app/
├── manifests/
├── kotlin+java/com.boshra.news/
│   ├── ui/
│   │   ├── component/       
│   │   ├── navigation/
│   │   │   ├── Navigation.kt        ✅ Required
│   │   │   └── Route.kt   
│   │   ├── screens/
│   │   │   ├── NewsListScreen.kt    ✅ Required
│   │   │   └── ArticleDetailsScreen.kt ✅ Required
│   │   └── theme/ 
│   │
│   ├── view_model/
│   │   ├── NewsViewModel.kt         ✅ Required
│   │   └── NewsViewModelFactory.kt
│   │
│   └── MainActivity.kt              ✅ Required
```

---

# 🚀 Task Flow

## 1️⃣ MainActivity (Start Here)

### Requirements:

* Initialize `NewsRepoImpl`
* Pass it to `NewsAppNavigation`

```kotlin id="5c8z0g"
val repo = NewsRepoImpl(...)
NewsAppNavigation(repo)
```

---

## 2️⃣ ViewModel (Core Task 🔥)

> ⚠️ This is the most important part — work on it right after MainActivity

### 🔹 Fetch Data

* Use:

```kotlin id="l0bbp9"
getBreakingNewsUseCase()
```

* It returns a `Flow` → convert it into a **StateFlow (Hot Flow)**

---

### 🔹 UI State

Create:

```kotlin id="0g3rpr"
MutableStateFlow<UiState>
```

Typical states:

* Loading
* Success
* Error

---

### 🔹 Selected Article

```kotlin id="v0h07f"
val selectedArticle = MutableStateFlow<Article?>(null)
```

---

### 🔹 Functions

#### ✔ onSelectArticle

```kotlin id="f1x5pz"
fun onSelectArticle(article: Article) {
    selectedArticle.value = article
}
```

---

#### ✔ onRefreshNewsFromRemote

* Re-fetch news from the remote source

---

#### ✔ onDeleteArticle

* Delete an article

---

## 3️⃣ Navigation (Navigation.kt)

### Requirements:

* Initialize **UseCases**
* Pass `repo` to them
* Create `ViewModel` using a factory
* Pass `ViewModel` to screens

```kotlin id="4r6f5l"
val useCases = NewsUseCases(...)

val viewModel = viewModel(
    factory = viewmodelFactory(useCases)
)

NewsListScreen(viewModel)
ArticleDetailsScreen(viewModel)
```

---

## 4️⃣ NewsListScreen

### Requirements:

* Collect UI state:

```kotlin id="tq4e3n"
val state by viewModel.uiState.collectAsStateWithLifecycle()
```

---

### Handle states inside `PullToRefreshBox`:

```kotlin id="d2gq3f"
when(state) {
    is Loading -> { /* Show Loading UI */ }
    is Success -> { /* Show News List */ }
    is Error -> { /* Show Error Message */ }
}
```

> ⚠️ UI is already implemented — just connect each state to the correct UI section

---

## 5️⃣ ArticleDetailsScreen

### Requirements:

* Collect selected article:

```kotlin id="y9g2p1"
val article by viewModel.selectedArticle.collectAsStateWithLifecycle()
```

---

### Two cases:

#### 🟡 `article == null`

* Show placeholder / empty UI

#### 🟢 `article != null`

* Show article details

---

# 🎯 Final Goal

✔ Connect all layers together
✔ Enable data flow: **Domain → ViewModel → UI**
✔ Make UI reactive to state changes
✔ Handle user interactions properly

---

# 🧠 Concepts Covered

* Clean Architecture
* MVVM
* Kotlin Flow (Cold vs Hot)
* StateFlow
* Reactive UI with Jetpack Compose

---

# 📌 Notes

* ❌ Do NOT modify UI design
* ✅ Focus only on logic
* ⚡ App must be reactive using Flow

---

💪 Good luck — once the ViewModel is done correctly, everything else will fall into place.
