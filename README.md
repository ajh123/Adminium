# Adminium

Adminium is a powerful Minecraft server utility mod designed to simplify and enhance server administration. With features for punishment management, ban management, and more, Adminium is your ultimate toolkit for maintaining order, efficiency and style on your Minecraft server.

## Features

### Current Features

- **Punishment Management**

  - Easily manage warnings, mutes, kicks, and other disciplinary actions.
  - Flexible configuration for tailored punishment policies.

- **Ban Management**

  - Advanced tools for banning and unbanning players.
  - Includes temporary and permanent ban options.
  - Comprehensive ban logs for quick reviews.

- **Permission Management**

  - Built-in system for managing player permissions.
  - Define roles and assign permissions directly within Adminium.

- **Database Integration**

  - Optional support for database integration to store bans, permissions, and other data persistently.

### Future Features

- **Tablist Formatting**

  - Customise the server tablist with player ranks, stats, and more.

- **Chat Formatting**

  - Enhance chat messages with custom colours, prefixes, and other formatting options.

**Each feature can be configured! (including completly disabling it!)**

## Supported Loaders and Versions

| Loader   | Supported Versions |
| -------- | ------------------ |
| Minestom | Latest Stable      |
| Fabric   | `0.16.9 1.20.1`   |

## Installation

1. Download the latest release of Adminium from [Releases](#).
2. Place the `.jar` file into your server's `mods` folder.
3. Restart your server.

## Configuration

Adminium includes a highly configurable system to tailor the mod to your server's needs. After installation:

1. Navigate to the `config/adminium` folder.
2. Edit the configuration files (`punishments.json`, `bans.json`, `permissions.json`, etc.) to your preference.
3. Reload the configuration by restarting the server or using the `/adminium reload` command.

If using a database, configure your database connection details in `database.json`.

## Commands

| Command                        | Description                             | Permission         |
| ------------------------------ | --------------------------------------- | ------------------ |
| `/warn <player>`               | Issue a warning to a player.            | `adminium.warn`    |
| `/mute <player>`               | Mute a player for a specified duration. | `adminium.mute`    |
| `/kick <player>`               | Kick a player from the server.          | `adminium.kick`    |
| `/ban <player>`                | Permanently ban a player.               | `adminium.ban`     |
| `/tempban <player>`            | Temporarily ban a player.               | `adminium.tempban` |
| `/unban <player>`              | Remove a ban from a player.             | `adminium.unban`   |
| `/adminium reload`             | Reload the configuration files.         | `adminium.reload`  |
| `/role add <role>`             | Create a new role.                      | `adminium.role`    |
| `/role assign <player> <role>` | Assign a role to a player.              | `adminium.role`    |
| `/role remove <player> <role>` | Remove a role from a player.            | `adminium.role`    |

## Permissions

Adminium includes a built-in permission management system. Define roles and assign permissions directly through Adminium's configuration files or using commands. No external permission management mod is required.

## Contributing

Contributions are welcome! If you have ideas or find bugs, please open an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch for your feature or fix.
3. Commit your changes with clear descriptions.
4. Submit a pull request to the main repository.

## License

Adminium is licensed under the [MIT License](LICENSE).

## Support

If you encounter any issues or need assistance, please use the following channels:

- Open an issue on [GitHub Issues](#).
- Start a discussion on [GitHub Discussions](#).

Thank you for using Adminium!

