# Oaster Architecture

## Goals
- Original, maintainable Kotlin/Compose Multiplatform codebase for Android (phone/tablet/TV) and Windows desktop.
- Clear boundaries, testable domain/data logic, smooth 60/120fps UI, and fast local playback.

## Stack
- **Language:** Kotlin (all targets)
- **UI:** Jetpack Compose (Android), Compose Multiplatform (desktop/shared UI)
- **Architecture:** Clean Architecture + MVVM + Unidirectional Data Flow (UDF)
- **Async:** Kotlin Coroutines + Flow
- **DI:** Koin (multiplatform-consistent) or Hilt on Android; choose one and apply consistently across modules (recommended: Koin for KMP sharing). *Decision to be finalized at scaffold; document choice in build files.*
- **Persistence:** Room on Android; SQLDelight or Room KMP for shared/multiplatform persistence (finalize based on KMP maturity for targets). Store library index, playlists, favorites, history, settings, cached metadata/artwork refs.
- **Audio:** Android Media3/ExoPlayer with gapless playback, background service, MediaSession, notification controls, audio focus. Desktop: native audio backend (e.g. Java Sound / maintained Kotlin library) with equivalent gapless and responsive behavior.
- **Networking:** Ktor client (metadata/artwork/lyrics/scrobbling stretch features).
- **Images:** Coil/Kamel or equivalent Compose-friendly caching loader with LRU memory/disk cache.

## Layers

### Presentation (`composeApp` / feature UI + `core/design-system`)
- Compose screens and components, state holders/ViewModels, navigation, adaptive layout selection.
- Consumes domain use cases and exposes immutable UI state + events.
- No direct data-source access.

### Domain (`core/domain`)
- Pure Kotlin models, repository interfaces, and use cases/interactors (e.g. ScanLibrary, PlayTrack, ManageQueue, ManagePlaylist, SearchLibrary).
- Business rules, no framework/UI dependencies.

### Data (`core/data`)
- Repository implementations, local data sources (DB, file scanner, metadata reader), remote sources (future), mappers.
- MediaStore/file-system scanning on Android; file-system scanning on desktop. All I/O off main thread.

### Core modules
- `core/design-system`: tokens, theme, glass components, adaptive navigation, motion.
- `core/audio`: playback engine abstraction and platform implementations.
- `core/common`: utilities, result/error types, dispatchers, logging (no emojis).

## Adaptive UI
- Use WindowSizeClass / BoxWithConstraints / adaptive navigation suites to select layout per hardware: phone (bottom bar), tablet (rail + two-pane), desktop (sidebar + multi-column, keyboard/hover), TV (10-foot, D-pad focus-driven).
- Each viewport intentionally designed and tested per device matrix.

## State and Navigation
- Single source of truth per screen via ViewModel state flows.
- Unidirectional events/actions from UI to ViewModel.
- Shared player state surfaced globally for mini-player and now-playing continuity.

## Performance Principles
- Main-safe: all disk/network/decoding work on background dispatchers.
- Lazy lists/grids with stable keys, artwork caching/prefetch, debounced search.
- Baseline profiles (Android) and profiling checkpoints before release.

## Testing
- Unit tests for domain use cases and data mappers/repositories.
- UI/screenshot and navigation tests for critical flows where feasible.
- Manual verification per device matrix (including TV remote and 1080p/4K).
