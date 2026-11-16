# Features Reference (Functional Surface Only)

Source reviewed for feature-surface understanding only: [MetrolistGroup/Metrolist](https://github.com/MetrolistGroup/Metrolist) (README and public repository overview, 2026-11-16).

This document is a plain checklist of common modern music-player capabilities observed in the open-source music-player ecosystem. It contains no copied UI design, code, assets, class names, or naming conventions. Oaster will implement a deliberately different, original product focused on local-first playback and Cutozmie design.

## Observed Feature Surface (Ecosystem)

### Playback
- [ ] Play / pause / previous / next
- [ ] Seek / scrub
- [ ] Shuffle
- [ ] Repeat modes (off / all / one)
- [ ] Queue view and queue editing
- [ ] Gapless playback
- [ ] Background playback with system media controls
- [ ] Audio focus handling
- [ ] Sleep timer
- [ ] Equalizer / audio effects (platform-dependent)

### Library and Organization
- [ ] Local media scan and indexing
- [ ] Tracks, albums, artists, genres views
- [ ] Artwork display and caching
- [ ] Playlists (create, rename, delete, add/remove/reorder tracks)
- [ ] Favorites / liked items
- [ ] Play history / recently played
- [ ] Metadata reading (tags, duration, artwork)
- [ ] Optional metadata editing

### Discovery and Search
- [ ] Search across tracks, albums, artists, playlists
- [ ] Fast, debounced search with relevant results
- [ ] Sorting and filtering

### Now Playing Experience
- [ ] Full now-playing screen with artwork and progress
- [ ] Persistent mini player across navigation
- [ ] Queue access from now playing
- [ ] Lyrics display (static/synced where available)

### Settings and Personalization
- [ ] Theme options (light / dark / OLED)
- [ ] Library folder/source management
- [ ] Audio and playback preferences
- [ ] About / version / licenses

### Platform and UX
- [ ] Responsive layouts for phone, tablet, desktop, TV
- [ ] Keyboard, touch, and remote/D-pad input support
- [ ] Accessibility (screen readers, focus, contrast, scaling)
- [ ] Smooth transitions and performant scrolling

### Online / Extended Capabilities (not core to Oaster v1)
- [ ] Streaming service integration
- [ ] Account sign-in
- [ ] Scrobbling integrations
- [ ] Casting / remote devices
- [ ] Cloud sync / backup-import from many services
- [ ] Music recognition
- [ ] Video playback

## Oaster Core Scope (from product brief)

Oaster v1 will prioritize local-first playback and library management:
- Local library scan and indexing
- Playback controls (play/pause/next/previous/seek/shuffle/repeat)
- Queue management
- Playlists and favorites
- Search (tracks/albums/artists/playlists)
- Album and artist views
- Now Playing + persistent mini player
- Settings (theme, audio, library folders, about)
- Background playback with media session/notification controls (Android)
- Sleep timer
- Equalizer where feasible (Android)

Stretch goals after core is solid: synced lyrics (LRC), Last.fm scrobbling, smart playlists, metadata editing.
