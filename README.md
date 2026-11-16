# Oaster

**Oaster** (pronounced "OH-ster") is an original, open-source music player by **Cutozmie**.

> Oaster — sound, served different.

Oaster is a fast, local-first music player designed from scratch with a liquid-glass visual language, a capsule hero experience, and adaptive layouts for phone, tablet, Android TV, and Windows desktop. It is built with Kotlin and Compose/Compose Multiplatform as a native product (no Electron, Flutter, React Native, or web wrappers).

## Project status

This repository currently contains the **product foundation**: feature-surface analysis, brand assets, and the documented design system (tokens, components, motion), plus architecture/performance/deploy planning and a CI template.

Screen and application code is intentionally **not** implemented yet, per the execution plan: implementation begins only after the design system is documented and approved.

## Brand

- **Product:** Oaster
- **Company/brand:** Cutozmie
- **Tagline:** "Oaster — sound, served different." (alt: "Oaster — your music, your way.")
- **Assets:** [`brand/logo/`](brand/logo/) and [`brand/brandmark/`](brand/brandmark/) (original SVG logomark, wordmark, Cutozmie mark)

## Design system

- [Tokens](design/tokens.md): color (light/dark/OLED), elevation/glass/blur, spacing, radius, typography, focus/accessibility
- [Components](design/components.md): GlassSurface, CapsuleHero, adaptive navigation, player/library/input components, states, focus/remote behavior
- [Motion](design/motion.md): spring-based transitions, shared elements, parallax, performance and reduce-motion rules

Signature language: real frosted/liquid glass (with fallback), capsule hero, smooth spring motion, consistent professional iconography (no emojis).

## Planned core features

- Local library scan and indexing
- Playback: play/pause, next/previous, seek, shuffle, repeat (off/all/one)
- Queue management (add, reorder, remove, clear)
- Playlists (create, rename, delete, add/remove/reorder)
- Favorites / liked tracks
- Search across tracks, albums, artists, playlists
- Album and artist views with artwork
- Now Playing (full screen) and persistent mini player
- Settings: theme (light/dark/OLED), audio, library folders, about
- Background playback with media session and notification controls (Android)
- Sleep timer
- Equalizer where feasible (Android)

Stretch (after core is solid): synced lyrics (LRC), Last.fm scrobbling, smart playlists, metadata editing.

See [docs/features-reference.md](docs/features-reference.md) for the ecosystem feature-surface checklist used for planning (functional reference only).

## Device support matrix (planned)

| Target | Layout | Input | Verification |
|---|---|---|---|
| Phone (portrait/landscape) | Bottom navigation, compact capsule hero | Touch | Pending |
| Tablet (portrait/landscape) | Rail, two-pane, expanded hero | Touch | Pending |
| Windows laptop/desktop | Sidebar, multi-column, resizable | Mouse, keyboard, hover | Pending |
| Android TV (1080p/4K) | 10-foot focus-driven UI | D-pad remote | Pending |

Details: [docs/device-matrix.md](docs/device-matrix.md)

## Architecture

- Clean Architecture (presentation/domain/data), MVVM + UDF
- Kotlin Coroutines + Flow, Koin/Hilt DI (finalized at scaffold)
- Persistence: Room/SQLDelight (multiplatform strategy finalized at scaffold)
- Audio: Media3/ExoPlayer (Android), native backend (desktop), gapless and responsive
- Networking: Ktor client (for future metadata/lyrics/scrobbling)

Details: [docs/architecture.md](docs/architecture.md)

## Build and deploy

Build instructions, CI template, release checklist, and store-asset placeholders: [docs/deploy.md](docs/deploy.md)

Targets: Android phone/tablet (APK/AAB), Android TV (APK), Windows desktop (installer/portable). CI workflow template: `.github/workflows/build.yml`.

## Performance and accessibility

- Performance targets and checklist: [docs/performance.md](docs/performance.md)
- Accessibility goals: content descriptions, TalkBack, keyboard and D-pad navigation, visible focus states, contrast, font scaling, and reduce-motion respect.

## License

Licensed under the [Apache License 2.0](LICENSE).

## Acknowledgment

Oaster is an original Cutozmie product. Its feature set was informed by studying the open-source music-player ecosystem (including public feature overviews such as Metrolist) at a functional level only; no UI design, source code, assets, or naming were copied.

## Contributing

Contribution guidelines will be added alongside the initial code scaffold. Contributions must follow the design system, architecture boundaries, accessibility/performance requirements, and project rules (no emojis, consistent iconography, original implementation).
